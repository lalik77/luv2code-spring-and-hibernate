package com.mami.luv2codes.validation;


import com.mami.luv2codes.model.Customer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseCodeConstraintValidatorTest {

    private CourseCodeConstraintValidator validatorUnderTest = new CourseCodeConstraintValidator();

    Customer customerUnderTest = new Customer();

    void setup() {
        customerUnderTest.setCourseCode("LUV");
        validatorUnderTest.initialize("LUV");
    }


    @Nested
    class CourseCodeValidFlow {
        @Test
        void isValid_shouldReturnTrue_whenStartWithLUV() {
           assertTrue(isValid("LUV"));
        }
    }




    private boolean isValid(String luv) {
        return validatorUnderTest.isValid(luv,null);

    }

}