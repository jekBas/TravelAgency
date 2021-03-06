package org.example.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.annotation.FieldMatch;
import org.example.annotation.ValidEmail;
import org.example.annotation.ValidName;
import org.example.annotation.ValidPassword;
import org.example.model.Role;
import org.example.model.User;
import org.springframework.stereotype.Component;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Component
@FieldMatch(first = "confirmPassword", second = "password", message = "The password fields must match")
public class UserDto {


    private Long id;

    @ValidName
    private String firstName;


    @ValidName
    private String lastName;


    @ValidName
    private String userName;

    @ValidPassword
    private String password;

    private String confirmPassword;


    @ValidEmail(message = "invalid email")

    private String email;

    private Role role;

    public UserDto() {}

    public UserDto(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.role = user.getRoles();
        this.id = user.getId();
    }


}