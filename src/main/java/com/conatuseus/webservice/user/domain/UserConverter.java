package com.conatuseus.webservice.user.domain;

import com.conatuseus.webservice.user.service.dto.UserSaveResponse;
import com.conatuseus.webservice.user.service.dto.UserUpdateResponse;

public class UserConverter {

    public static UserSaveResponse toSaveResponse(final User user) {
        return new UserSaveResponse();
    }

    public static UserUpdateResponse toUpdateResponse(final User user) {
        return UserUpdateResponse.builder()
            .email(user.getEmail())
            .password(user.getPassword())
            .name(user.getName())
            .phoneNumber(user.getPhoneNumber())
            .build();
    }
}
