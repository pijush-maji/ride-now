package com.ridenow.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserSignUp {


    @NotBlank(message = "Name can't be blank")
    private String name;
    @Email(message = "Not a valid email")
    @NotBlank(message = "Email can't be blank")
    private String email;
    @NotBlank(message = "Password can't be blank")
    private String password;
    @NotBlank(message = "User role can't be blank")
    private String userRole;

    public @NotBlank(message = "Name can't be blank") String getName() {
        return name;
    }

    public @Email(message = "Not a valid email") @NotBlank(message = "Email can't be blank") String getEmail() {
        return email;
    }

    public @NotBlank(message = "Password can't be blank") String getPassword() {
        return password;
    }

    public void setName(@NotBlank(message = "Name can't be blank") String name) {
        this.name = name;
    }

    public void setEmail(@Email(message = "Not a valid email") @NotBlank(message = "Email can't be blank") String email) {
        this.email = email;
    }

    public void setPassword(@NotBlank(message = "Password can't be blank") String password) {
        this.password = password;
    }

    public @NotBlank(message = "User role can't be blank") String getUserRole() {
        return userRole;
    }

    public void setUserRole(@NotBlank(message = "User role can't be blank") String userRole) {
        this.userRole = userRole;
    }
}
