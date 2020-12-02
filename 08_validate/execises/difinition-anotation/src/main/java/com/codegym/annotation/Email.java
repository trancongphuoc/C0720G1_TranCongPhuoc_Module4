package com.codegym.annotation;

import com.codegym.validator.EmailValidaor;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = EmailValidaor.class)
public @interface Email {

    String message() default "Age > 18";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
