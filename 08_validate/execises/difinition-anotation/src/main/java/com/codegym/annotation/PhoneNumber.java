package com.codegym.annotation;


import com.codegym.validator.PhoneValidater;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = PhoneValidater.class)
public @interface PhoneNumber {

    String message() default "Phone wrong!!!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
