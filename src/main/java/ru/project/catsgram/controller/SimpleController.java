package ru.project.catsgram.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class SimpleController {

    private static final Logger log = LoggerFactory.getLogger(SimpleController.class);
    @GetMapping("/home")
    public String homePage() {
        log.info("Запрос получен.");
        return "Котограм.";
    }
}
