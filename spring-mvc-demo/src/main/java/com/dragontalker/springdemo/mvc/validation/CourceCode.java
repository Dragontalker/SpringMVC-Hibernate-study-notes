package com.dragontalker.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )
public @interface CourceCode {

}
