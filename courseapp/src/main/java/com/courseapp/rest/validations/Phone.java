package com.courseapp.rest.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Payload;

@Documented
@javax.validation.Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ java.lang.annotation.ElementType.FIELD })
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)

public @interface Phone {

	String message() default "phone number format is not correct";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
