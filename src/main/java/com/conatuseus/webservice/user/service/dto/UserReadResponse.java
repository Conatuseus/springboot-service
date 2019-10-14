package com.conatuseus.webservice.user.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserReadResponse {

    private String email;
    private String password;
    private String name;
    private String phoneNumber;
}
