package com.mami.luv2codes.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NoWhitespacesValidator implements ConstraintValidator<NoWhitesSpace, String> {


   String prefix;

   public void initialize(NoWhitesSpace constraint) {
     prefix =  constraint.value();
   }

   public boolean isValid(String value, ConstraintValidatorContext context) {

      boolean result = !value.contains(" ") && value.startsWith(prefix);

      return result;

   }
}
