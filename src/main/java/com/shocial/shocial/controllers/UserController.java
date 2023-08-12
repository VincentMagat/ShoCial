package com.shocial.shocial.controllers;

import com.shocial.shocial.model.UserModel;
import com.shocial.shocial.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/signup")
    public String getSignUpPage(Model model){
        model.addAttribute("registerRequest", new UserModel());
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute UserModel userModel) {
        System.out.println("sign up request : " + userModel);
        UserModel registeredUser = userService.registerUser(userModel.getUsername(),
                                                            userModel.getPassword(),
                                                            userModel.getEmail());

        return registeredUser == null ? "error" : "redirect:/";
    }

    @GetMapping("/")
    public String showLandingPage(Model model){
        model.addAttribute("loginRequest", new UserModel());
        return "landing";
    }

    @PostMapping("/")
    public String login(@ModelAttribute UserModel userModel, Model model) {
        System.out.println("login request : " + userModel);
        UserModel authenticated = userService.authenticate(userModel.getUsername(), userModel.getPassword());

        if(authenticated != null) {
            model.addAttribute("username", authenticated.getUsername());
            return "profile";
        } else {
            System.out.println("Login not found");
            return "error";
        }
    }

}
