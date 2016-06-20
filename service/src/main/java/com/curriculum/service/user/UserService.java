package com.curriculum.service.user;

import com.curriculum.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User find(String id);

    Page<User> findAll(Pageable pageable, String search);

    void save(User user);

    Long countByEmail(String email);

    User findByEmail(String email);
}
