package com.mami.luv2codes.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NoWhitespacesValidator implements ConstraintValidator<NoWhitesSpace, String> {


   public void initialize(NoWhitesSpace constraint) {
   }

   public boolean isValid(String value, ConstraintValidatorContext context) {


      return !value.contains(" ");

   }
}
