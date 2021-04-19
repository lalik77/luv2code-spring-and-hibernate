package com.mami.luv2codes.validation;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoWhitespacesValidatorTest {


    private NoWhitespacesValidator validator = new NoWhitespacesValidator();

    @Nested
    class NoWhitespaceValidFlow {
        @Test
        void isValid_shouldReturnTrue_whenNoWhitespaces() {
            assertTrue(isValid(""));
            assertTrue(isValid("foo.bar"));
        }
    }

    @Nested
    class NoWhitespacesInvalidFlow {
        @Test
        void isValid_shouldReturnFalse_whenAtLeastOneWhitespace() {
            assertFalse(isValid(" "));
            assertFalse(isValid("foo bar"));
            assertFalse(isValid("  foo"));
            assertFalse(isValid("foo  "));
        }
    }

    private boolean isValid(String value) {
        return validator.isValid(value, null);
    }

}