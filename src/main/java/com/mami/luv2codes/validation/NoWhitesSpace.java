package com.mami.luv2codes.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = NoWhitespacesValidator.class)
@Target({ FIELD })
@Retention(RUNTIME)
public @interface NoWhitesSpace {

    String value() default "stack";
    String message() default "Not valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
