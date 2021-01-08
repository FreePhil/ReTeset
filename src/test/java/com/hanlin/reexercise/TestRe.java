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
    public void TestUrl_Nullability() throws Exception
    {
        String targetUrl = null;

        boolean validatedResult = validator.isValidUrl(targetUrl);
        Assertions.assertFalse(validatedResult);
    }

    @Test
    public void TestUrl_Empty() throws Exception
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
    public void TestUrl_Http(String targetUrl) throws Exception {

        boolean validatedResult = validator.isValidUrl(targetUrl);
        Assertions.assertTrue(validatedResult);
    }

    @Test
    public void TestEmail_Null() throws Exception {
        String targetAddress = null;

        boolean validatedResult = validator.isValidUrl(targetAddress);
        Assertions.assertFalse(validatedResult);
    }

    @Test
    public void TestEmail_Empty() throws Exception {
        String targetAddress = "";

        boolean validatedResult = validator.isValidUrl(targetAddress);
        Assertions.assertFalse(validatedResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "tom@gmail.com",
            "jason.chen@hanlin.com.tw",
            "jane@microsoft.com.tw",
    })
    public void TestEmail_Address(String targetAddress) throws Exception {

        boolean validatedResult = validator.isValidUrl(targetAddress);
        Assertions.assertTrue(validatedResult);
    }
}
