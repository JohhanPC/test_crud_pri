package com.proyectoPri.registerUser.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestUserDto {
    private String name;
    private String email;
    private String password;
    private String identificationNumber;
    private String identificationType;
}
