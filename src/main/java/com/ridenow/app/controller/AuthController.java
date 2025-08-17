package com.ridenow.app.controller;

import com.ridenow.app.dto.LoginDto;
import com.ridenow.app.dto.LoginRes;
import com.ridenow.app.dto.SignupRes;
import com.ridenow.app.dto.UserSignUp;
import com.ridenow.app.exception.InvalidLoginException;
import com.ridenow.app.exception.UserAlreadyExistsException;
import com.ridenow.app.model.User;
import com.ridenow.app.service.AuthService;
import com.ridenow.app.service.JwtService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@CrossOrigin()
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final Logger log = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private AuthService authService;
    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<LoginRes> login(@RequestBody LoginDto loginDto) throws InvalidLoginException {
        User authenticated = authService.authenticate(loginDto);
        String token = jwtService.generateToken(authenticated,authenticated.getRole());
        LoginRes loginRes = new LoginRes();
        loginRes.setToken(token);
        return new ResponseEntity<>(loginRes,HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupRes> singUp(@Valid @RequestBody UserSignUp userSignUp, BindingResult bindingResult)
            throws UserAlreadyExistsException {
        if(bindingResult.hasErrors()){
            log.info("Invalid request data->"+ Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            return new ResponseEntity<>(new SignupRes("Invalid request data"), HttpStatus.BAD_REQUEST);
        }
        SignupRes signupRes = authService.signUp(userSignUp);
        return new ResponseEntity<>(signupRes, HttpStatusCode.valueOf(201));
    }
}
