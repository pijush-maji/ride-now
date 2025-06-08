package com.ridenow.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/driver")
public class DriverController {

    @PostMapping("/login")
    public String login(){
        return "Logged In";
    }
}
