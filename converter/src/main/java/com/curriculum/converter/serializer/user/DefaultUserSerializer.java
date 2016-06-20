package com.curriculum.converter.serializer.user;

import com.curriculum.converter.AbstractConverter;
import com.curriculum.domain.user.User;
import com.curriculum.dto.user.UserDTO;
import org.springframework.stereotype.Component;

@Component("defaultUserSerializer")
public class DefaultUserSerializer extends AbstractConverter<User, UserDTO> {

    @Override
    public UserDTO convert(User user, UserDTO userDTO) {
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setPatronymicName(user.getPatronymicName());
        userDTO.setLastName(user.getLastName());
        userDTO.setDepartment(user.getDepartment());
        userDTO.setPosition(user.getPosition());
        userDTO.setEmail(user.getEmail());
        userDTO.setRole(user.getRole());
        return userDTO;
    }

    @Override
    public UserDTO convert(User user) {
        return convert(user, new UserDTO());
    }
}