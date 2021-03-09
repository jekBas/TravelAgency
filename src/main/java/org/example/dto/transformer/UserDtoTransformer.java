package org.example.dto.transformer;

import org.example.dto.UserDto;
import org.example.model.User;

public class UserDtoTransformer {

    public static UserDto convertUserToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUserName(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getRoles());
    }

    public static User convertUserDtoToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUserName(userDto.getUserName());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(user.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRoles(userDto.getRole());

        return user;
    }
}