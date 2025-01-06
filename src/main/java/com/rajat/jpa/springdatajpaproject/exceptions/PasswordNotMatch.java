package com.rajat.jpa.springdatajpaproject.exceptions;

import org.aspectj.bridge.Message;

public class PasswordNotMatch extends Exception{
    public PasswordNotMatch(String message) {
        super(message);
    }
}
