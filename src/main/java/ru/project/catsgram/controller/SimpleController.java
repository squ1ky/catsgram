package ru.project.catsgram.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class SimpleController {

    @GetMapping("/home")
    public String homePage() {
        return "Котограм.";
    }
}
