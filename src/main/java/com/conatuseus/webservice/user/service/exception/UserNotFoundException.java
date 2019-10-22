package com.conatuseus.webservice.user.service.exception;

import com.conatuseus.webservice.exception.ErrorResponseException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class UserNotFoundException extends ErrorResponseException {

    private static final String USER_NOT_FOUND_MESSAGE = "해당 유저를 찾을 수 없습니다.";

    public UserNotFoundException() {
        super(USER_NOT_FOUND_MESSAGE, NOT_FOUND);
    }
}
