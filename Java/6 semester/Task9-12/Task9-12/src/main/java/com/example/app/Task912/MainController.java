package com.example.app.Task912;

import com.example.app.Task912.registration.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {
    @GetMapping("/")
    public String mainMenu(@ModelAttribute User user){
        return "mainMenu";
    }
}
