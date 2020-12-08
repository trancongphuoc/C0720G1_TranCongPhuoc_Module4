package com.codegym.validator;

import com.codegym.anotation.CheckNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberValidator implements ConstraintValidator<CheckNumber, Double> {
   public void initialize(CheckNumber constraint) {
   }

   public boolean isValid(Double obj, ConstraintValidatorContext context) throws NumberFormatException{
      return obj > 0;
   }
}
