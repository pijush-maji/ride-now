package com.ridenow.app.service;

import com.ridenow.app.constant.UserRole;
import com.ridenow.app.dto.LoginDto;
import com.ridenow.app.dto.SignupRes;
import com.ridenow.app.dto.UserSignUp;
import com.ridenow.app.exception.InvalidLoginException;
import com.ridenow.app.exception.UserAlreadyExistsException;
import com.ridenow.app.model.User;
import com.ridenow.app.repository.UserRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AuthService {

    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepo userRepo, AuthenticationManager authenticationManager){
        this.userRepo=userRepo;
        this.authenticationManager=authenticationManager;
    }

    public SignupRes signUp(UserSignUp userSignUp) throws UserAlreadyExistsException{
        Optional<User> userExists = userRepo.findByEmail(userSignUp.getEmail());
        if(userExists.isPresent()){
            throw new UserAlreadyExistsException("User with email "+userSignUp.getEmail()+" already exists!");
        }else{
            User user = new User();
            user.setName(userSignUp.getName());
            user.setEmail(userSignUp.getEmail());
            user.setPassword(userSignUp.getPassword());
            user.setCreatedAt(String.valueOf(new Date()));
            user.setUpdatedAt(String.valueOf(new Date()));
            user.setRole(UserRole.valueOf(userSignUp.getUserRole()));
            User save = userRepo.save(user);
            return new SignupRes("User created successfully");
        }
    }

    public User authenticate(LoginDto loginDto) throws InvalidLoginException {
        Optional<User> user = userRepo.findByEmail(loginDto.getEmail());
        if(user.isPresent()){
            User existingUser = user.get();
            if(existingUser.getPassword().equals(loginDto.getPassword()))
                return user.get();
            else
                throw new InvalidLoginException("Invalid password");
        }
        throw new InvalidLoginException("No account present with provided email");
    }
}
