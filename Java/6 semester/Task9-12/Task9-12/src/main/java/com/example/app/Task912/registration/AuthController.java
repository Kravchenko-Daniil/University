package com.example.app.Task912.registration;

import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;


    public AuthController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String loginGet(@ModelAttribute("user") User user) {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationGet(Model model) {
        model.addAttribute("user", new User());
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String registrationPost(@ModelAttribute("userForm") @Valid User user, Model model) {

        if(!userService.saveUser(user)){
            return "redirect:/auth/error";
        } else {
            return "redirect:/auth/login";
        }
    }

    @GetMapping("/admin")
    public String adminPage(Model model){
        model.addAttribute("users", userService.getUsers());
        return "/auth/admin";
    }
}
