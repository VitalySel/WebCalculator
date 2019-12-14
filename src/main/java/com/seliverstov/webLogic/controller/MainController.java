package com.seliverstov.webLogic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "greeting";
    }

    @GetMapping("/greeting")
    public String greeting() {
        return "greeting";
    }


}