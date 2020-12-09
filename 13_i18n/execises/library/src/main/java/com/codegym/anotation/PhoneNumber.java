package com.codegym.anotation;

import com.codegym.validator.NumberPhoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = NumberPhoneValidator.class)
@Documented
public @interface PhoneNumber {

    String message() default "0XXXXXXXXX";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
