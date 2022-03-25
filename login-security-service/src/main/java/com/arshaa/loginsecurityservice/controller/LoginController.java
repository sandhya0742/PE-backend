package com.arshaa.loginsecurityservice.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {

    @GetMapping("/home")
        public String home () {
            return "home";

    }
}
