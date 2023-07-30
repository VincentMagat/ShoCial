package com.shocial.shocial.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {
    @GetMapping("/signup")
    public String signUp(){
        // TODO: Try making this work,
        // TODO: Capture the inputs from front-end, turn it into the Object model.
        // TODO: Goal is to see the inputs registered to your DB
        return "signup";
    }

}
