package com.example.auth.controllers;

import com.example.auth.services.UserService;
import com.example.auth.vo.RegistrationVo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/sign_up")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public String registerUser(@RequestBody RegistrationVo registrationVo) {
        return userService.registerUser(registrationVo);
    }

}
