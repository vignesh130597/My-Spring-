package com.spring.postgres.dto;

public class ValidationConstant {
    public static String FIRSTNAME_CANNOT_BE_NULL = "FirstName should not be empty";
    public static String EMAIL_ADDRESS_CANNOT_BE_NULL = "Email address should not be empty";
    public static String EMAIL_ADDRESS_ALREADY_EXIT = "Email address already exist";
    public static String LASTNAME_CANNOT_BE_NULL = "Lastname should not be empty";
    public static String FIRST_SPL = "First name should not contain Special character";
    public static String LAST_SPL = "Lastname should not contain Special character";
    public static String FIRST_SPACE = "First name should not Accept space";
    public static String LAST_SPACE = "Lastname should not Accept space";
    public static String ID_MIS_MATCH = "User id mismatch";
    public static String INVALID_EMAIL = "Enter the valid email address";
    public static String ID_NOT_NULL = "User id cannot be null";
}
