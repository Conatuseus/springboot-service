package com.conatuseus.webservice.user.domain;

import com.conatuseus.webservice.user.service.dto.UserResponse;

public class UserConverter {

    public static UserResponse toResponse(final User user) {
        return UserResponse.builder()
            .email(user.getEmail())
            .password(user.getPassword())
            .gender(user.getGender())
            .name(user.getName())
            .phoneNumber(user.getPhoneNumber())
            .build();
    }
}
