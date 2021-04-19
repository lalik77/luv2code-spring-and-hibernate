package com.mami.luv2codes.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

   private String coursePrefix;


   public void initialize(CourseCode constraint) {

      coursePrefix = constraint.value();
   }

   public boolean isValid(String theCode,
                          ConstraintValidatorContext theConstraintValidator) {

      boolean result;

      if(theCode!=null) {

      result = theCode.startsWith(coursePrefix);
      } else {
          return true;
      }

      return result;
   }
}
