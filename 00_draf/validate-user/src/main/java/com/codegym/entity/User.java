package com.codegym.entity;



import com.codegym.common.Validator;
import org.springframework.validation.Errors;

import javax.persistence.*;

@Entity(name = "user")
public class User implements org.springframework.validation.Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "date_of_birth", columnDefinition = "DATE")
    private String dateOfBirth;

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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if (!Validator.validateName(user.firstName)) {
            errors.rejectValue("firstName", "first-name.wrong");
        }
        if (!Validator.validateName(user.lastName)) {
            errors.rejectValue("lastName", "last-name.wrong");
        }
        if (!Validator.validatePhoneNumber(user.phoneNumber)) {
            errors.rejectValue("phoneNumber", "phone-number.wrong");
        }
        if (user.dateOfBirth.equals("")) {
            errors.rejectValue("dateOfBirth", "date-of-birth-empty.wrong");
        } else if (!Validator.validateDateOfBirth(user.dateOfBirth)) {
            errors.rejectValue("dateOfBirth", "date-of-birth.wrong");
        }
        if (!Validator.validateEmail(user.email)) {
            errors.rejectValue("email", "email.wrong");
        }
    }
}
