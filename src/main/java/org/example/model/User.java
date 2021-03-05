package org.example.model;

import lombok.Data;
import org.example.dto.UserDto;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username",unique = true)
    private String userName;


    @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;


    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role roles;

    public User() {
    }

    public User(UserDto userDto){
        this.firstName = userDto.getFirstName();
        this.lastName = userDto.getLastName();
        this.userName = userDto.getUserName();
        this.password = userDto.getPassword();
        this.email = userDto.getEmail();
        if(userDto.getRole() == null){
            this.roles = Role.USER;
        }else this.roles = userDto.getRole();

    }

    public User(String userName, String firstName, String lastName, String email, String password) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = Role.USER;
    }
}