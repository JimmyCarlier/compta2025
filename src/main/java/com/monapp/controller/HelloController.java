package com.monapp.controller;

import java.time.Year;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// Permet d'indiquet que l'on fournis un template
@Controller
public class HelloController {

    // Le chemin du controller
    @GetMapping("/")
    public String hello(Model model) {
        int year = Year.now().getValue();
        model.addAttribute("title", "Comptabilité " + year);
        return "home"; // Affiche home.html
    }
}
