package com.curriculum.facade.authentication;

import com.curriculum.domain.token.Token;
import com.curriculum.domain.user.User;
import com.curriculum.dto.authentication.AuthenticationDTO;
import com.curriculum.dto.authentication.AuthorizationDTO;
import com.curriculum.exception.AuthenticationException;
import com.curriculum.exception.ContentNotFoundException;
import com.curriculum.service.security.SecurityService;
import com.curriculum.service.token.TokenService;
import com.curriculum.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("defaultAuthenticationFacade")
public class DefaultAuthenticationFacade implements AuthenticationFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultAuthenticationFacade.class);

    @Autowired
    @Qualifier("defaultSecurityService")
    private SecurityService securityService;

    @Autowired
    @Qualifier("defaultUserService")
    private UserService userService;

    @Autowired
    @Qualifier("defaultTokenService")
    private TokenService tokenService;

    @Autowired
    @Qualifier("passwordEncoder")
    private PasswordEncoder passwordEncoder;

    @Override
    public Token login(final AuthenticationDTO authenticationDTO) {
        LOGGER.info("DefaultAuthenticationFacade.login(), email={}", authenticationDTO.getEmail());
        final String errorMessage = "Incorrect email or password";

        final User user;
        try {
            user = userService.findByEmail(authenticationDTO.getEmail());
        } catch (final ContentNotFoundException e) {
            LOGGER.error("DefaultAuthenticationFacade.login(), email={}, message", authenticationDTO.getEmail(), e.getValue());
            throw new AuthenticationException(errorMessage);
        }

        if (!passwordEncoder.matches(authenticationDTO.getPassword(), user.getPassword())) {
            LOGGER.error("DefaultAuthenticationFacade.login(), email={}, message", authenticationDTO.getEmail(), errorMessage);
            throw new AuthenticationException(errorMessage);
        }

        final Token token = tokenService.create(user);

        LOGGER.info("DefaultAuthenticationFacade.login() finished");
        return token;
    }

    @Override
    public void logout() {
        LOGGER.info("DefaultAuthenticationFacade.logout()");
        final String id = securityService.getCredentials();
        tokenService.delete(id);
        SecurityContextHolder.clearContext();
        LOGGER.info("DefaultAuthenticationFacade.logout() finished");
    }

    @Override
    public AuthorizationDTO current() {
        LOGGER.info("DefaultAuthenticationFacade.current()");
        final User currentUser = securityService.getCurrentUser();
        final AuthorizationDTO authorizationDTO = new AuthorizationDTO();

        authorizationDTO.setId(currentUser.getId());
        authorizationDTO.setRole(currentUser.getRole());

        final String fullName = currentUser.getFirstName() + " " + currentUser.getLastName();
        authorizationDTO.setFullName(fullName);

        LOGGER.info("DefaultAuthenticationFacade.current() finished");
        return authorizationDTO;
    }
}
