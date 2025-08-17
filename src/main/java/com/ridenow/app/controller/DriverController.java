package com.ridenow.app.controller;

import com.ridenow.app.model.User;
import com.ridenow.app.service.DriverService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/driver")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService){
        this.driverService=driverService;
    }

    @GetMapping("/getNearbyRiders")
    public List<User> getNearbyRiders(){
        return driverService.getNearbyRiders();
    }
}
