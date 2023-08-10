package com.progrunners.fakturica.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/")
    public String showHome() {
        return "home";
    }
}
