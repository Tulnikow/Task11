package ru.tiulnikow.springboot1.model;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Pattern(message = "Bad formed user name: ${validatedValue}",
            regexp = "^[A-Z][a-z]*(\\s(([a-z]{1,3})|(([a-z]+\\')?[A-Z][a-z]*)))*$")
    @NotEmpty(message = "Name must not be empty")
    @Size(min = 2, max = 40, message = "Name must be between 2 and 40 characters long")
    @Column(name = "USER_NAME")
    private String userName;

    @Pattern(message = "Bad formed user lastname: ${validatedValue}",
            regexp = "^[A-Z][a-z]*(\\s(([a-z]{1,3})|(([a-z]+\\')?[A-Z][a-z]*)))*$")
    @NotEmpty(message = "Lastname must not be empty")
    @Size(min = 2, max = 100, message = "Lastname must be between 2 and 100 characters long")
    @Column(name = "USER_LASTNAME")
    private String userLastname;
    @Email(message = "Email address has invalid format: ${validatedValue}",
            regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
    @NotEmpty(message = "Mail must not be empty")
    @Size(min = 2, max = 100, message = "Mail must be between 2 and 100 characters long")
    @Column(name = "USER_MAIL")
    private String userMail;

    @DecimalMax(message = "User age can not exceed 130",
            value = "130")
    @DecimalMin(message = "User age should be positive",
            value = "0", inclusive = false)
    @Column(name = "USER_AGE")
    private int userAge;

    public User() {
    }

    public User(int id, String userName, String userLastName, String userMail, int userAge) {
        this.id = id;
        this.userName = userName;
        this.userLastname = userLastName;
        this.userMail = userMail;
        this.userAge = userAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userLastname='" + userLastname + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}

