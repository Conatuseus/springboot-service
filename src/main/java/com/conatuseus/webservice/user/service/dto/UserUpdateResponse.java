package com.conatuseus.webservice.user.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserUpdateResponse {

    private String email;
    private String password;
    private String name;
    private String phoneNumber;
}
