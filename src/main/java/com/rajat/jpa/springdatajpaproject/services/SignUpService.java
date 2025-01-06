package com.rajat.jpa.springdatajpaproject.services;

import com.rajat.jpa.springdatajpaproject.exceptions.InvalidPassword;
import com.rajat.jpa.springdatajpaproject.exceptions.PasswordNotMatch;
import com.rajat.jpa.springdatajpaproject.exceptions.UserNotFound;
import com.rajat.jpa.springdatajpaproject.exceptions.duplicateEmailException;
import com.rajat.jpa.springdatajpaproject.models.User;

public interface SignUpService {
    public boolean addUser(User user) throws PasswordNotMatch, duplicateEmailException;
    public User findUser(User user) throws UserNotFound, InvalidPassword;
}
