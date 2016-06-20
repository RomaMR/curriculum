package com.curriculum.web.controller;

import com.curriculum.domain.user.User;
import com.curriculum.dto.check.CheckDTO;
import com.curriculum.dto.user.PasswordDTO;
import com.curriculum.dto.user.UserDTO;
import com.curriculum.facade.user.UserFacade;
import com.curriculum.web.config.API;
import com.curriculum.web.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(API.User.ROOT)
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    @Qualifier("defaultUserFacade")
    private UserFacade userFacade;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<UserDTO>> findAll(@RequestParam(value = "offset", required = false) final Integer offset,
                                                 @RequestParam(value = "limit", required = false) final Integer limit,
                                                 @RequestParam(value = "search", required = false) final String search) {
        LOGGER.info("UserController.findAll(), offset={}, limit={}, search={}", offset, limit, search);
        final Pageable pageable = PaginationUtil.generatePageRequest(offset, limit);
        final Page<UserDTO> page = userFacade.findAll(pageable, search);
        LOGGER.info("UserController.findAll() finished");
        return new ResponseEntity(page, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody User user) {
        LOGGER.info("UserController.save()");
        userFacade.save(user);
        LOGGER.info("UserController.save() finished");
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public ResponseEntity update(@PathVariable("id") String id, @RequestBody User user) {
        LOGGER.info("UserController.update()");
        userFacade.update(id, user);
        LOGGER.info("UserController.update() finished");
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = API.User.PASSWORD, method = RequestMethod.PATCH)
    public ResponseEntity changePassword(@PathVariable("id") String id, @RequestBody PasswordDTO passwordDTO) {
        LOGGER.info("UserController.changePassword(), id={}", id);
        userFacade.changePassword(id, passwordDTO);
        LOGGER.info("UserController.changePassword() finished");
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = API.User.ROLE, method = RequestMethod.PATCH)
    public ResponseEntity changeRole(@PathVariable("id") String id, @RequestBody User user) {
        LOGGER.info("UserController.changeRole(), id={}", id);
        userFacade.changeRole(id, user);
        LOGGER.info("UserController.changeRole() finished");
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = API.User.EMAIL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CheckDTO> checkByEmail(@PathVariable("email") final String email) {
        LOGGER.info("UserController.checkByEmail(), email = {}", email);
        final CheckDTO checkDTO = userFacade.checkByEmail(email);
        LOGGER.info("UserController.checkByEmail() finished");
        return new ResponseEntity(checkDTO, HttpStatus.OK);
    }

    @RequestMapping(value = API.User.CURRENT, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> current() {
        LOGGER.info("UserController.current()");
        final UserDTO userDTO = userFacade.current();
        LOGGER.info("UserController.current() finished");
        return new ResponseEntity(userDTO, HttpStatus.OK);
    }

}
