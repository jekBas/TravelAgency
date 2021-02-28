package org.example.model;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Entity
@Table(name = "user")//single form name..............................................................//
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Pattern(regexp = "[A-Z][a-z]+(-[A-Z][a-z]+){0,1}",
            message = "Must start with a capital letter followed by one or more lowercase letters")
    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Pattern(regexp = "[A-Z][a-z]+(-[A-Z][a-z]+){0,1}",
            message = "Must start with a capital letter followed by one or more lowercase letters")
    @Column(name = "last_name")
    private String lastName;

    @Email(message = "Must be a valid e-mail address")
    @Column(name = "email")
    private String email;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?$\\.&]{8,}$",
            message = "Must be minimum 8 characters, at least one uppercase, one lowercase, one number and one special character")
    @NotNull
    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role roles;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = Role.USER;
    }
}