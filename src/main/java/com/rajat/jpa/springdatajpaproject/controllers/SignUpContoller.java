package com.rajat.jpa.springdatajpaproject.controllers;

import com.rajat.jpa.springdatajpaproject.exceptions.InvalidPassword;
import com.rajat.jpa.springdatajpaproject.exceptions.PasswordNotMatch;
import com.rajat.jpa.springdatajpaproject.exceptions.UserNotFound;
import com.rajat.jpa.springdatajpaproject.exceptions.duplicateEmailException;
import com.rajat.jpa.springdatajpaproject.models.User;
import com.rajat.jpa.springdatajpaproject.services.SignUpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpContoller {
    private SignUpService signUpService;


    public SignUpContoller(SignUpService signUpService) {
        this.signUpService = signUpService;
    }



    @GetMapping("/signup")
    public String getSignUpPage(Model model){
        model.addAttribute("user",new User());
       return "signup";
    }

    @GetMapping("/login")
    public String getLogInPage(Model model){
        model.addAttribute("user",new User());
        return "login";
    }



    @PostMapping("/signup")
    public String getSignUpSuccessPage(@ModelAttribute("user") User u1,Model model){


        try {
             signUpService.addUser(u1);
        } catch (PasswordNotMatch e) {
            model.addAttribute("passwordNotMatch",e.getMessage());
            return "signup";
        } catch (duplicateEmailException e){
            model.addAttribute("DupicateEmail",e.getMessage());
            return "signup";
        }


        model.addAttribute("name",u1.getUsername());
        return "login-success";
    }

    @PostMapping("/login")
    public String getLogInSuccessPage(@ModelAttribute("user") User user, Model model) {
        User u1;
        try {
            u1 = signUpService.findUser(user);
        } catch (UserNotFound e) {
            model.addAttribute("usernotfound", e.getMessage());
            return "login";
        } catch (InvalidPassword e) {
            model.addAttribute("invalidpassowrd", e.getMessage());
            return "login";
        }

        model.addAttribute("username", u1.getUsername());
        return "login-success";
    }

}
