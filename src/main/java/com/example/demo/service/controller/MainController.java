package com.example.demo.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public String home() {
        return "index";  // Nom du fichier HTML dans le dossier templates
    }
}
