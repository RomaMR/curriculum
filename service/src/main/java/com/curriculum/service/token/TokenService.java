package com.curriculum.service.token;

import com.curriculum.domain.token.Token;
import com.curriculum.domain.user.User;

public interface TokenService {
    Token create(final User user);

    Token find(final String value);

    void delete(final String id);
}
