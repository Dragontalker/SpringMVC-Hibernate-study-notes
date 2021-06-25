package com.dragontalker.springdemo.mvc.validation;

import javax.validation.Constraint;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
public @interface CourceCode {

}
