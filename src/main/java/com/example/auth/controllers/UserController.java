package com.example.auth.controllers;

import com.example.auth.models.AppRoles;
import com.example.auth.models.AppUser;
import com.example.auth.services.UserService;
import com.example.auth.util.AppResponse;
import com.example.auth.vo.RegistrationVo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/api/v1/sign_up")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<AppResponse> registerUser(@RequestBody RegistrationVo registrationVo) {
        userService.registerUser(
            new AppUser(
                registrationVo.getEmail(),
                registrationVo.getFirstName(),
                registrationVo.getLastName(),
                passwordEncoder.encode(registrationVo.getPassword()),
                false,
                AppRoles.User
            )
        );

        return ResponseEntity.ok(
            AppResponse.builder()
                .timeStamp(LocalDateTime.now())
                .status(OK)
                .message("User created successfully.")
                .build()
        );
    }
}