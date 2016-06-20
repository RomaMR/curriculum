package com.curriculum.service.token;

import com.curriculum.domain.token.Token;
import com.curriculum.domain.user.User;
import com.curriculum.exception.ContentNotFoundException;
import com.curriculum.persistence.token.TokenRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service("defaultTokenService")
public class DefaultTokenService implements TokenService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultTokenService.class);

    @Autowired
    @Qualifier("tokenRepository")
    private TokenRepository tokenRepository;

    @Override
    public Token create(final User user) {
        LOGGER.info("DefaultTokenService.create(), userId={}", user.getId());
        final Token token = new Token();

        final UUID uuid = UUID.randomUUID();
        token.setId(uuid.toString());

        token.setUserId(user.getId());
        token.setUserRole(user.getRole());

        final Date creationDate = new Date();
        token.setCreationDate(creationDate);

        final Token savedToken = tokenRepository.save(token);
        LOGGER.info("DefaultTokenService.create() finished");
        return savedToken;
    }

    @Override
    public Token find(final String id) {
        LOGGER.info("DefaultTokenService.find()");
        final Token token = tokenRepository.findOne(id);
        if (token == null) {
            final String message = "Token not found";
            LOGGER.error("DefaultUserService.find(), id={}, message={}", id, message);
            throw new ContentNotFoundException(message);
        }
        LOGGER.info("DefaultTokenService.find() finished");
        return token;
    }

    @Override
    public void delete(final String id) {
        LOGGER.info("DefaultTokenService.delete()");
        tokenRepository.delete(id);
        LOGGER.info("DefaultTokenService.delete() finished");
    }

}
