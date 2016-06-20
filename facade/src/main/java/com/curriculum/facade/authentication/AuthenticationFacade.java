package com.curriculum.facade.authentication;

import com.curriculum.domain.token.Token;
import com.curriculum.dto.authentication.AuthenticationDTO;
import com.curriculum.dto.authentication.AuthorizationDTO;

public interface AuthenticationFacade {
    Token login(AuthenticationDTO authenticationDTO);

    void logout();

    AuthorizationDTO current();
}
