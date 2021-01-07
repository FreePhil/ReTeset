package com.hanlin.reexercise;

public interface InternetValidatorInterface {
    boolean isValidUrl(String url) throws Exception;
    boolean isValidEmail(String email) throws Exception;
}
