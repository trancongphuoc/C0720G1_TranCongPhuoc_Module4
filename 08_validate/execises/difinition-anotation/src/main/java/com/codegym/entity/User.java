package com.codegym.entity;

import com.codegym.annotation.Age;
import com.codegym.annotation.Email;
import com.codegym.annotation.Name;
import com.codegym.annotation.PhoneNumber;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Name(message = "Please input format correct")
    @Column(name = "first_name")
    private String firstName;

    @Name(message = "Please input format correct")
    @Column(name = "last_name")
    private String lastName;

    @PhoneNumber(message = "Please input format correct")
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotBlank(message = "Field not empty")
    @Age
    @Column(name = "date_of_birth", columnDefinition = "DATE")
    private String dateOfBirth;

    @Email(message = "Email format exception")
    @Column(name = "email")
    private String email;

    public User() {
    }

    public User(Integer id, String firstName, String lastName, String phoneNumber, String dateOfBirth, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
