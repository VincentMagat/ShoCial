package com.shocial.shocial.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class signupPage {
    @GetMapping("/sign")
    public String showSignPage(){
        return "sign";
    }
}
