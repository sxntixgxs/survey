package com.sxntixgxs.survey.slices.rol.infrastructure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RolController {
    @GetMapping("/login")
    public String login(){
        return "index";
    }
}
