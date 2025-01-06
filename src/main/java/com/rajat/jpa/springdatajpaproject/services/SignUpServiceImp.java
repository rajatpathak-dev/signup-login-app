package com.rajat.jpa.springdatajpaproject.services;

import com.rajat.jpa.springdatajpaproject.exceptions.InvalidPassword;
import com.rajat.jpa.springdatajpaproject.exceptions.PasswordNotMatch;
import com.rajat.jpa.springdatajpaproject.exceptions.UserNotFound;
import com.rajat.jpa.springdatajpaproject.exceptions.duplicateEmailException;
import com.rajat.jpa.springdatajpaproject.models.User;
import com.rajat.jpa.springdatajpaproject.repository.SignUpRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignUpServiceImp implements SignUpService{

    private final SignUpRepo signUpRepo;

    public SignUpServiceImp(SignUpRepo signUpRepo) {
        this.signUpRepo = signUpRepo;
    }

    @Override
    public boolean addUser(User user) throws PasswordNotMatch,duplicateEmailException{
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            throw  new PasswordNotMatch("Password not match !");
        }

        if(isEmailExists(user.getEmail())){
            throw  new duplicateEmailException("Email Already Exist");
        }

        signUpRepo.save(user);
        return true;
    }

    @Override
    public User findUser(User user) throws UserNotFound,InvalidPassword {
        if(!isEmailExists(user.getEmail())){
            throw  new UserNotFound("Email Not Found! ");
        }

        User u1 = signUpRepo.findByEmail(user.getEmail()).get();

        if(!user.getPassword().equals(u1.getPassword())){
            throw  new InvalidPassword("Invalid Password!");
        }


        return u1;
    }



    public boolean isEmailExists(String email) {
        return signUpRepo.findByEmail(email).isPresent();
    }
}
