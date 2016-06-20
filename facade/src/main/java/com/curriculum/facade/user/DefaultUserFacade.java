package com.curriculum.facade.user;

import com.curriculum.converter.Converter;
import com.curriculum.domain.user.Role;
import com.curriculum.domain.user.User;
import com.curriculum.dto.check.CheckDTO;
import com.curriculum.dto.user.PasswordDTO;
import com.curriculum.dto.user.UserDTO;
import com.curriculum.exception.BadRequestException;
import com.curriculum.service.security.SecurityService;
import com.curriculum.service.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("defaultUserFacade")
public class DefaultUserFacade implements UserFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultUserFacade.class);

    @Autowired
    @Qualifier("defaultUserService")
    private UserService userService;

    @Autowired
    @Qualifier("defaultSecurityService")
    private SecurityService securityService;

    @Autowired
    @Qualifier("passwordEncoder")
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier("defaultUserSerializer")
    private Converter<User, UserDTO> userSerializer;

    @Override
    public Page<UserDTO> findAll(final Pageable pageable, final String search) {
        LOGGER.info("DefaultUserFacade.findAll(), page={}, search={}", pageable.getOffset(), search);
        final Page<User> page = userService.findAll(pageable, search);
        final List<UserDTO> userDTOs = userSerializer.convertAll(page.getContent());
        LOGGER.info("DefaultUserFacade.findAll() finished");
        return new PageImpl<>(userDTOs, pageable, page.getTotalElements());
    }

    @Override
    public void save(final User user) {
        LOGGER.info("DefaultUserFacade.save()");

        final Long userCount = userService.countByEmail(user.getEmail());
        if (userCount > 0L) {
            final String message = "Email is already in use";
            LOGGER.error("DefaultUserFacade.save(), email={}, message={}", user.getEmail(), message);
            throw new BadRequestException(message);
        }

        final User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setPatronymicName(user.getPatronymicName());
        newUser.setLastName(user.getLastName());
        newUser.setDepartment(user.getDepartment());
        newUser.setPosition(user.getPosition());
        newUser.setEmail(user.getEmail());

        final String encodedPassword = passwordEncoder.encode(user.getPassword());
        newUser.setPassword(encodedPassword);

        newUser.setRole(Role.READ);

        userService.save(newUser);
        LOGGER.info("DefaultUserFacade.save() finished");
    }

    @Override
    public CheckDTO checkByEmail(final String email) {
        LOGGER.info("DefaultUserFacade.checkByEmail(), email = {}", email);
        final Long count = userService.countByEmail(email);

        final CheckDTO checkDTO = new CheckDTO();
        checkDTO.setCondition("email");

        final boolean present = count != 0;
        checkDTO.setValue(present);

        LOGGER.info("DefaultUserFacade.checkByEmail() finished");
        return checkDTO;
    }

    @Override
    public UserDTO current() {
        LOGGER.info("DefaultUserFacade.current()");
        final User currentUser = securityService.getCurrentUser();
        final UserDTO userDTO = userSerializer.convert(currentUser);
        LOGGER.info("DefaultUserFacade.current() finished");
        return userDTO;
    }

    @Override
    public void changeRole(final String id, final User user) {
        LOGGER.info("DefaultUserFacade.changeRole(), id={}", id);
        final User persistentUser = userService.find(id);

        final String role = user.getRole();

        final String principal = securityService.getPrincipal();
        if (principal.equals(id)) {
            final String message = "You can not change your role!";
            LOGGER.error("DefaultUserFacade.changeRole(), id={}, message={}", id, message);
            throw new BadRequestException(message);
        }

        if ((StringUtils.isBlank(role)) && (!Role.READ.equals(role)) && (!Role.WRITE.equals(role)) && (!Role.ADMIN.equals(role))) {
            final String message = "Role is not specified";
            LOGGER.error("DefaultUserFacade.changeRole(), id={}, message={}", id, message);
            throw new BadRequestException(message);
        }

        persistentUser.setRole(role);

        userService.save(persistentUser);
        LOGGER.info("DefaultUserFacade.changeRole() finished");
    }

    @Override
    public void update(final String id, final User user) {
        LOGGER.info("DefaultUserFacade.update(), id={}", id);
        final User persistentUser = userService.find(id);

        final String firstName = user.getFirstName();
        if (StringUtils.isNotBlank(firstName)) {
            persistentUser.setFirstName(firstName);
        }
        final String lastName = user.getLastName();
        if (StringUtils.isNotBlank(lastName)) {
            persistentUser.setLastName(lastName);
        }
        final String patronymicName = user.getPatronymicName();
        if (StringUtils.isNotBlank(patronymicName)) {
            persistentUser.setPatronymicName(patronymicName);
        }
        final String department = user.getDepartment();
        if (StringUtils.isNotBlank(department)) {
            persistentUser.setDepartment(department);
        }
        final String position = user.getPosition();
        if (StringUtils.isNotBlank(position)) {
            persistentUser.setPosition(position);
        }

        final String email = user.getEmail();
        if (StringUtils.isNotBlank(email) && !(persistentUser.getEmail().equals(email))) {

            final Long userCount = userService.countByEmail(user.getEmail());
            if (userCount > 0L) {
                final String message = "Email is already in use";
                LOGGER.error("DefaultUserFacade.update(), email={}, message={}", user.getEmail(), message);
                throw new BadRequestException(message);
            }

            user.setEmail(email);
        }

        userService.save(persistentUser);
        LOGGER.info("DefaultUserFacade.update() finished");
    }

    @Override
    public void changePassword(final String id, final PasswordDTO passwordDTO) {
        LOGGER.info("DefaultUserFacade.changePassword(), id={}", id);
        final User persistentUser = userService.find(id);

        final boolean matches = passwordEncoder.matches(passwordDTO.getPassword(), persistentUser.getPassword());
        if (!matches) {
            final String message = "Wrong password";
            LOGGER.error("DefaultUserFacade.changePassword(), id={}, message={}", id, message);
            throw new BadRequestException(message);
        }

        if (StringUtils.isBlank(passwordDTO.getNewPassword()) || !(passwordDTO.getNewPassword().equals(passwordDTO.getConfirmPassword()))) {
            final String message = "Please choose correct new password";
            LOGGER.error("DefaultUserFacade.changePassword(), id={}, message={}", id, message);
            throw new BadRequestException(message);
        }

        final String newPassword = passwordEncoder.encode(passwordDTO.getNewPassword());
        persistentUser.setPassword(newPassword);

        userService.save(persistentUser);
        LOGGER.info("DefaultUserFacade.changePassword() finished");
    }
}
