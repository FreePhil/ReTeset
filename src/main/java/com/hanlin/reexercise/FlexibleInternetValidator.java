package com.hanlin.reexercise;

public class FlexibleInternetValidator implements InternetValidatorInterface {

    @Override
    public boolean isValidUrl(String url) throws Exception {
        throw new Exception("No implmentation");
    }

    @Override
    public boolean isValidEmail(String email) throws Exception {
        throw new Exception("No implmentation");
    }
}
