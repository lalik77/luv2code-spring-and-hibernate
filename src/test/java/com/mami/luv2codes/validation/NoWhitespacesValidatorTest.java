package com.mami.luv2codes.validation;

import com.mami.luv2codes.model.Customer;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class NoWhitespacesValidatorTest {

    private NoWhitesSpace noWhitesSpace = mock(NoWhitesSpace.class);

    private ConstraintValidatorContext constraintValidatorContext = mock(ConstraintValidatorContext.class);

    @Test
    public void itShouldBeValidWhenItStartsWithPrefixAndWithoutWhiteSpace(){

        when(noWhitesSpace.value()).thenReturn("stack");

        NoWhitespacesValidator noWhitespacesValidator=new NoWhitespacesValidator();
        noWhitespacesValidator.initialize(noWhitesSpace);

        Customer customer = new Customer();
        customer.setCourseCode("stack_rty");

        boolean result = noWhitespacesValidator.isValid(customer.getCourseCode(),constraintValidatorContext);

        assertTrue(result);
    }


}