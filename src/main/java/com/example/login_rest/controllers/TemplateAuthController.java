package com.example.login_rest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateAuthController {
    @GetMapping("login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("register")
    public String registerPage() {
        return "register";
    }

    // Ruta para el dashboard principal
    @GetMapping("/layout")
    public String dashboard() {
        return "layout"; // Vista principal
    }
}
