package com.curriculum.service.security;

import com.curriculum.domain.user.User;

public interface SecurityService {
    String getPrincipal();

    String getCredentials();

    boolean isUserInRole(String role);

    User getCurrentUser();

}
