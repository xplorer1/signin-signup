package com.example.auth.services;

import com.example.auth.models.AppUser;
import com.example.auth.repositories.AppUserRepo;
import com.example.auth.repositories.UserRepo;
import com.example.auth.util.AppResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final AppUserRepo appUserRepo;

    public ResponseEntity<?> registerUser(AppUser appUser) {

        boolean userExists = appUserRepo.findByEmail(appUser.getEmail()).isPresent();

        if(userExists) {
            System.out.println("exuser: " + userExists);

            return ResponseEntity.ok(
                AppResponse.builder()
                    .timeStamp(LocalDateTime.now())
                    .status(HttpStatus.CONFLICT)
                    .message("User exists")
                    .build()
            );
        } else {
            appUserRepo.saveAndFlush(appUser);

            return ResponseEntity.ok(
                    AppResponse.builder()
                            .timeStamp(LocalDateTime.now())
                            .status(HttpStatus.OK)
                            .message("User created successfully.")
                            .build()
            );
        }
    }
}
