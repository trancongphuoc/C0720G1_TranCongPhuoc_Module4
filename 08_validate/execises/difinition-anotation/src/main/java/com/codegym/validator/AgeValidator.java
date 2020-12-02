package com.codegym.validator;

import com.codegym.annotation.Age;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class AgeValidator implements ConstraintValidator<Age, String> {
   public void initialize(Age constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      if (obj.equals("")) {
         return true;
      }

      LocalDate today = LocalDate.now();
      LocalDate dateOfBirth = LocalDate.parse(obj);

      return (today.getYear() - dateOfBirth.getYear() >= 18);
   }
}
