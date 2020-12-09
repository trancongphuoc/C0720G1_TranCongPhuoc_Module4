package com.codegym.validator;

import com.codegym.anotation.CheckName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator implements ConstraintValidator<CheckName, String> {
   public void initialize(CheckName constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      Pattern pattern = Pattern.compile("^[A-Z][a-z]+(\\s[A-Z][a-z]+)*$");
      Matcher matcher = pattern.matcher(obj);
      return matcher.matches();
   }

}
