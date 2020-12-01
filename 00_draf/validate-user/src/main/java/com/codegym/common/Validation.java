package com.codegym.common;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static void main(String[] args) {
        String numberPhone = "090123456";
        System.out.println(validatePhoneNumber(numberPhone));
    }

    private static Pattern pattern;
    private static Matcher matcher;

    private static final String REGEX_NAME = "^[A-Z][a-z]*(//s[A-Z][a-z]*)*$";
    private static final String REGEX_PHONE_NUMBER = "^(090|091|082|083)\\d{7}$";
    private static final String REGEX_EMAIL = "^[\\w]{3,20}(.?[\\w]{1,10})*@[a-z]{1,10}.[a-z]{1,10}$";


    public static boolean validateName(String name) {
        pattern = Pattern.compile(REGEX_NAME);
        matcher = pattern.matcher(name);

        return matcher.matches();
    }

    public static boolean validatePhoneNumber(String number) {
        pattern = Pattern.compile(REGEX_PHONE_NUMBER);
        matcher = pattern.matcher(number);

        return matcher.matches();
    }

    public static boolean validateEmail(String email) {
        pattern = Pattern.compile(REGEX_EMAIL);
        matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public static boolean validateDateOfBirth(String dateOfBirth) {
        LocalDate dateNow = LocalDate.now();
        LocalDate birthday = LocalDate.parse(dateOfBirth);

        return dateNow.getYear() - birthday.getYear() >= 18;
    }
}
