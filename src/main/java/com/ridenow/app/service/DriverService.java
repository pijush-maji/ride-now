package com.ridenow.app.service;

import com.ridenow.app.model.User;
import com.ridenow.app.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DriverService {
    private final UserRepo userRepo;

    public DriverService(UserRepo userRepo){
        this.userRepo=userRepo;
    }
    //Now returnig the whole object later on add new Dto for riders
    public List<User> getNearbyRiders(){
        Optional<List<User>> nearByRiders = userRepo.findNearByRiders();
        return nearByRiders.orElseGet(ArrayList::new);
    }
}
