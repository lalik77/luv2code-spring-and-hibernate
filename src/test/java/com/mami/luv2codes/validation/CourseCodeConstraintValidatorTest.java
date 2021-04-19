package com.mami.luv2codes.validation;


import com.mami.luv2codes.model.Customer;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class CourseCodeConstraintValidatorTest {


    private CourseCode courseCode = mock(CourseCode.class);

    private ConstraintValidatorContext constraintValidator =
                                                      mock(ConstraintValidatorContext.class) ;

    @Test
    public void itShouldBeValid_whenItStartsWithLUV(){

        when(courseCode.value()).thenReturn("LUV");

        CourseCodeConstraintValidator courseCodeConstraintValidator = new CourseCodeConstraintValidator();
        courseCodeConstraintValidator.initialize(courseCode);

        Customer customer = new Customer();
        customer.setCourseCode("LUV!!!ttyy");

        boolean result = courseCodeConstraintValidator.isValid(customer.getCourseCode(),constraintValidator);

        assertTrue(result);

    }

    @Test
    public void itShouldNotBeValid_whenItStartsWithSpace_andLUV(){

        when(courseCode.value()).thenReturn("LUV");

        CourseCodeConstraintValidator courseCodeConstraintValidator = new CourseCodeConstraintValidator();
        courseCodeConstraintValidator.initialize(courseCode);

        Customer customer = new Customer();
        customer.setCourseCode(" LUV !!ttyy");

        boolean result = courseCodeConstraintValidator.isValid(customer.getCourseCode(),constraintValidator);

        assertFalse(result);

    }

    @Test
    public void itShouldBeValid_whenNoDataProvided(){

        when(courseCode.value()).thenReturn("LUV");

        CourseCodeConstraintValidator courseCodeConstraintValidator = new CourseCodeConstraintValidator();
        courseCodeConstraintValidator.initialize(courseCode);

        Customer customer = new Customer();


        boolean result = courseCodeConstraintValidator.isValid(customer.getCourseCode(),constraintValidator);

        assertTrue(result);

    }

}