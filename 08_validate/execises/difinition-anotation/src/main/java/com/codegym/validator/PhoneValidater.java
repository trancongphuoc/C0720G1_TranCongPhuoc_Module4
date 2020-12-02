package com.codegym.validator;

import com.codegym.annotation.PhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidater implements ConstraintValidator<PhoneNumber, String> {
   public void initialize(PhoneNumber constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      Pattern pattern = Pattern.compile("^(090|091|082|083)\\d{7}$");
      Matcher matcher = pattern.matcher(obj);
      return matcher.matches();
   }
}
