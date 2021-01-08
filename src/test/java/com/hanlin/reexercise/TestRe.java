package com.hanlin.reexercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

public class TestRe {

    private InternetValidatorInterface validator;

    @BeforeEach
    public void createReObject() {
        validator = new FlexibleInternetValidator();
    }

    @Test
    public void testUrl_Nullability() throws Exception
    {
        String targetUrl = null;

        boolean validatedResult = validator.isValidUrl(targetUrl);
        Assertions.assertFalse(validatedResult);
    }

    @Test
    public void testUrl_Empty() throws Exception
    {
        String targetUrl = "";

        boolean validatedResult = validator.isValidUrl(targetUrl);
        Assertions.assertFalse(validatedResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "http://www.hle.com.tw",
            "https://www.hle.com.tw",
            "http://testbank.hle.com.tw:8080/home",
            "https://www.hle.com.tw:80001/home/domain/",
            "https://www.hle.com.tw:80001/home/cp/calendar?subject=ch&year=50",
            "http://localhost:8080",
    })
    public void testUrl_Http(String targetUrl) throws Exception {

        boolean validatedResult = validator.isValidUrl(targetUrl);
        Assertions.assertTrue(validatedResult);
    }

    @Test
    public void testEmail_Null() throws Exception {
        String targetEmail = null;

        boolean validatedResult = validator.isValidEmail(targetEmail);
        Assertions.assertFalse(validatedResult);
    }

    @Test
    public void testEmail_Empty() throws Exception {
        String targetEmail = "";

        boolean validatedResult = validator.isValidEmail(targetEmail);
        Assertions.assertFalse(validatedResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "tom@gmail.com",
            "jason.chen@hanlin.com.tw",
            "jane@microsoft.com.tw",
    })
    public void testEmail_Address(String targetEmail) throws Exception {
        boolean validatedResult = validator.isValidEmail(targetEmail);

        Assertions.assertTrue(validatedResult);
    }
}
