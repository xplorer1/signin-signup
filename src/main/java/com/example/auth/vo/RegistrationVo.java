package com.example.auth.vo;

import lombok.*;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class RegistrationVo {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}