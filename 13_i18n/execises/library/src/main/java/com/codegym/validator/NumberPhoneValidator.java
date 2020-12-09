package com.codegym.validator;

import com.codegym.anotation.PhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class NumberPhoneValidator implements ConstraintValidator<PhoneNumber, String> {
   public void initialize(PhoneNumber constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      return Pattern.compile("^0\\d{9}$").matcher(obj).matches();
   }
}
