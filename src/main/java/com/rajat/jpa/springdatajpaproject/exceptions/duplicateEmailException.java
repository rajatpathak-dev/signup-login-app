package com.rajat.jpa.springdatajpaproject.exceptions;

import java.sql.SQLException;

public class duplicateEmailException extends SQLException {
    public duplicateEmailException(String message) {
        super(message);
    }
}
