package com.proyectoPri.registerUser.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchUserByEmail {
    private String name;
    private String email;

    public SearchUserByEmail(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
