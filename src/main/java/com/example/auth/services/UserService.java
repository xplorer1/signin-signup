package com.example.auth.services;

import com.example.auth.vo.RegistrationVo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String registerUser(RegistrationVo registrationVo) {
        return "Stuff is working.";
    }
}
