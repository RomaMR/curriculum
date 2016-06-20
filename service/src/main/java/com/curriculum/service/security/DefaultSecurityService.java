package com.curriculum.service.security;

import com.curriculum.domain.user.User;
import com.curriculum.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service("defaultSecurityService")
public class DefaultSecurityService implements SecurityService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultSecurityService.class);

    @Autowired
    @Qualifier("defaultUserService")
    private UserService userService;

    @Override
    public String getPrincipal() {
        LOGGER.info("DefaultSecurityService.getPrincipal()");
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if ((authentication == null) || !(authentication.getPrincipal() instanceof String)) {
            final String message = "Unauthorized";
            LOGGER.error("DefaultSecurityService.getPrincipal(), message={}", message);
            throw new BadCredentialsException(message);
        }

        final String principal = (String) authentication.getPrincipal();
        LOGGER.info("DefaultSecurityService.getPrincipal() finished");
        return principal;
    }

    @Override
    public String getCredentials() {
        LOGGER.info("DefaultSecurityService.getCredentials()");
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if ((authentication == null) || !(authentication.getCredentials() instanceof String)) {
            final String message = "Unauthorized";
            LOGGER.error("DefaultSecurityService.getCredentials(), message={}", message);
            throw new BadCredentialsException(message);
        }

        final String credentials = (String) authentication.getCredentials();
        LOGGER.info("DefaultSecurityService.getCredentials() finished");
        return credentials;
    }


    @Override
    public boolean isUserInRole(final String role) {
        LOGGER.info("DefaultSecurityService.isUserInRole()");
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if ((authentication == null) || (authentication.getAuthorities() == null)) {
            final String message = "Unauthorized";
            LOGGER.error("DefaultSecurityService.isUserInRole(), message={}", message);
            throw new BadCredentialsException(message);
        }

        final boolean isUserInRole = authentication.getAuthorities().contains(new SimpleGrantedAuthority(role));
        LOGGER.info("DefaultSecurityService.isUserInRole() finished");
        return isUserInRole;
    }

    @Override
    public User getCurrentUser() {
        LOGGER.info("DefaultSecurityService.getCurrentUser()");
        final String principal = getPrincipal();
        final User currentUser = userService.find(principal);
        LOGGER.info("DefaultSecurityService.getCurrentUser() finished");
        return currentUser;
    }

}