package com.skokul.plutoserv.auth.service;

import org.apache.commons.validator.routines.EmailValidator;

public class ValidationUtil {

    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty() || email.isBlank())
            return false;
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }

}
