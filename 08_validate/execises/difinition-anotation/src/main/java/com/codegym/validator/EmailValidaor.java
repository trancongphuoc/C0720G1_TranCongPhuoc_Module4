package com.codegym.validator;

import com.codegym.annotation.Email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidaor implements ConstraintValidator<Email, String> {
   public void initialize(Email constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      Pattern pattern = Pattern.compile("^[\\w]{3,20}(.?[\\w]{1,10})*@[a-z]{1,10}.[a-z]{1,10}$");
      Matcher matcher = pattern.matcher(obj);
      return matcher.matches();
   }
}
