package com.curriculum.service.user;

import com.curriculum.domain.user.QUser;
import com.curriculum.domain.user.User;
import com.curriculum.exception.ContentNotFoundException;
import com.curriculum.persistence.user.UserRepository;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("defaultUserService")
public class DefaultUserService implements UserService{
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultUserService.class);

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    @Override
    public User find(final String id) {
        LOGGER.info("DefaultUserService.find(), id = {}", id);
        final User user = userRepository.findOne(id);
        if (user == null) {
            final String message = "User not found";
            LOGGER.error("DefaultUserService.find(), id={}, message={}", id, message);
            throw new ContentNotFoundException(message);
        }
        LOGGER.info("DefaultUserService.find() finished");
        return user;
    }

    @Override
    public Page<User> findAll(final Pageable pageable, final String search) {
        LOGGER.info("DefaultUserService.findAll()");

        final BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (StringUtils.isNotBlank(search)) {
            final QUser qUser = QUser.user;
            booleanBuilder.or(qUser.firstName.containsIgnoreCase(search));
            booleanBuilder.or(qUser.lastName.containsIgnoreCase(search));
            booleanBuilder.or(qUser.patronymicName.containsIgnoreCase(search));
            booleanBuilder.or(qUser.email.containsIgnoreCase(search));
        }

        final Predicate predicate = booleanBuilder.getValue();
        final Page<User> users = userRepository.findAll(predicate, pageable);

        LOGGER.info("DefaultUserService.findAll() finished");
        return users;
    }

    @Override
    public void save(final User user) {
        LOGGER.info("DefaultUserService.save()");
        userRepository.save(user);
        LOGGER.info("DefaultUserService.save() finished");
    }

    @Override
    public Long countByEmail(final String email) {
        LOGGER.info("DefaultUserService.countByEmail(), email={}", email);
        final Long count = userRepository.countByEmail(email);
        LOGGER.info("DefaultUserService.countByEmail() finished, count={}", count);
        return count;
    }

    @Override
    public User findByEmail(final String email) {
        LOGGER.info("DefaultUserService.findByEmail(), email={}", email);
        final User user = userRepository.findByEmail(email);
        if (user == null) {
            final String message = "User not found";
            LOGGER.error("DefaultUserService.findByEmail(), email={}, message={}", email, message);
            throw new ContentNotFoundException(message);
        }
        LOGGER.info("DefaultUserService.findByEmail() finished");
        return user;
    }
}
