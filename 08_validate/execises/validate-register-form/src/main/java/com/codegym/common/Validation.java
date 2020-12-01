package com.codegym.common;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    private static Pattern pattern;
    private static Matcher matcher;

    private static final String REGEX_NAME = "^[A-Z][a-z]*(//s[A-Z][a-z]*)*$";
    private static final String REGEX_PHONE_NUMBER = "^(090)|(091)|(082)|(083)//d{7}$";
    private static final String REGEX_EMAIL = "^[A-Za-z]{3,20}(//.?[A-Za-z]{1,10})*@[A-Za-z]{1,10}.[A-Za-z]{1,10}$";


    public static boolean validateName(String name) {
        pattern = Pattern.compile(REGEX_NAME);
        matcher = pattern.matcher(name);

        return matcher.find();
    }

    public static boolean validatePhoneNumber(String number) {
        pattern = Pattern.compile(REGEX_PHONE_NUMBER);
        matcher = pattern.matcher(number);

        return matcher.find();
    }

    public static boolean validateEmail(String email) {
        pattern = Pattern.compile(REGEX_EMAIL);
        matcher = pattern.matcher(email);

        return matcher.find();
    }

    public static boolean validateDateOfBirth(String dateOfBirth) {
        LocalDate dateNow = LocalDate.now();
        LocalDate birthday = LocalDate.parse(dateOfBirth);

        return dateNow.getYear() - birthday.getYear() >= 18;
    }
}
