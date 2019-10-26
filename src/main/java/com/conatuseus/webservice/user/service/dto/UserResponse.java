package com.conatuseus.webservice.user.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponse {

    private String email;
    private String password;
    private String gender;
    private String name;
    private String phoneNumber;

    @Builder
    public UserResponse(final String email, final String password, final String gender, final String name, final String phoneNumber) {
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
