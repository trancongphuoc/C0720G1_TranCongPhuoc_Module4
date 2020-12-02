package com.codegym.validator;

import com.codegym.annotation.Name;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class NameValidator implements ConstraintValidator<Name, String> {

    @Autowired
    UserService userService;

    @Override
    public void initialize(Name constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern pattern = Pattern.compile("^[A-Z][a-z]*(//s[A-Z][a-z]*)*$");
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
