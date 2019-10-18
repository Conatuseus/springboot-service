package com.conatuseus.webservice.user.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserReadResponse {

    private String email;
    private String password;
    private String name;
    private String phoneNumber;

    @Builder
    public UserReadResponse(final String email, final String password, final String name, final String phoneNumber) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
