package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.annotation.FieldMatch;
import org.example.annotation.ValidEmail;
import org.example.annotation.ValidName;
import org.example.annotation.ValidPassword;
import org.example.model.Role;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
@FieldMatch(first = "confirmPassword", second = "password", message = "The password fields must match")
public class UserDto {

    private Long id;

    @ValidName
    private String userName;

    @ValidName
    private String firstName;

    @ValidName
    private String lastName;

    @ValidEmail(message = "invalid email")
    private String email;

    @ValidPassword
    private String password;

    private String confirmPassword;

    private Role role;

    public UserDto() {}

    public UserDto(Long id, String userName, String firstName, String lastName, String email, String password, Role role) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role  == null ? Role.USER : role;
    }
}