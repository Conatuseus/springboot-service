package com.conatuseus.webservice.user.domain;

import com.conatuseus.webservice.user.service.dto.UserSaveResponseDto;

public class UserConverter {

    public static UserSaveResponseDto toSaveResponse(User user) {
        return new UserSaveResponseDto();
    }
}
