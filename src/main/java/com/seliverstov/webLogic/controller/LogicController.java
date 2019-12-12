package com.seliverstov.webLogic.controller;

import org.springframework.stereotype.Controller;
import com.seliverstov.calculatorLogic.calculator.Calculator;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class LogicController {
    @GetMapping("/calculator")
    public String getIndex(){
        return "calculator";
    }

    @PostMapping("/calculator")
    public Model getAnswer(@RequestParam String exp, Model model){
        Calculator calculator = new Calculator();
        BigDecimal res = calculator.calculate(exp);
        model.addAttribute("exp",exp);
        model.addAttribute("res",res);
        return model;
    }
}
