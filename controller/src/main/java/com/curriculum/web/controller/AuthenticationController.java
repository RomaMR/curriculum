package com.curriculum.web.controller;

import com.curriculum.domain.token.Token;
import com.curriculum.dto.authentication.AuthenticationDTO;
import com.curriculum.dto.authentication.AuthorizationDTO;
import com.curriculum.facade.authentication.AuthenticationFacade;
import com.curriculum.web.config.API;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(API.Authentication.ROOT)
public class AuthenticationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    @Qualifier("defaultAuthenticationFacade")
    private AuthenticationFacade authenticationFacade;

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity logout(@RequestHeader(value = "Referer", required = false) final String referer) {
        LOGGER.info("AuthenticationController.logout()");
        final HttpHeaders headers = new HttpHeaders();
        authenticationFacade.logout();

        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(API.Headers.Cookie.TOKEN).append("=");
        if (StringUtils.isNotBlank(referer)) {
            stringBuilder.append("; path=/; ").append(referer);
        }

        final String tokenCookie = stringBuilder.toString();
        headers.add("Set-Cookie", tokenCookie);
        LOGGER.info("AuthenticationController.logout() finished");
        return new ResponseEntity(headers, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody AuthenticationDTO authenticationDTO, @RequestHeader(value = "Referer", required = false) final String referer) {
        LOGGER.info("AuthenticationController.login(), email={}", authenticationDTO.getEmail());
        final HttpHeaders headers = new HttpHeaders();
        final Token token = authenticationFacade.login(authenticationDTO);

        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(API.Headers.Cookie.TOKEN).append("=").append(token.getId());
        if (StringUtils.isNotBlank(referer)) {
         stringBuilder.append("; path=/; ").append(referer);
        }

        final String tokenCookie = stringBuilder.toString();
        headers.add("Set-Cookie", tokenCookie);
        LOGGER.info("AuthenticationController.login() finished");
        return new ResponseEntity(headers, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorizationDTO> current() {
        LOGGER.info("AuthenticationController.current()");
        final AuthorizationDTO authorizationDTO = authenticationFacade.current();
        LOGGER.info("AuthenticationController.current() finished");
        return new ResponseEntity(authorizationDTO, HttpStatus.OK);
    }
}
