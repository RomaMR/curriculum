package com.curriculum.facade.user;

import com.curriculum.domain.user.User;
import com.curriculum.dto.check.CheckDTO;
import com.curriculum.dto.user.PasswordDTO;
import com.curriculum.dto.user.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserFacade {

    Page<UserDTO> findAll(Pageable pageable, String search);

    void save(User user);

    CheckDTO checkByEmail(String email);

    UserDTO current();

    void changeRole(String id, User user);

    void update(String id, User user);

    void changePassword(String id, PasswordDTO passwordDTO);
}
