package com.conatuseus.webservice.developers.service.exception;

import com.conatuseus.webservice.exception.ErrorResponseException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class DeveloperNotFoundException extends ErrorResponseException {

    private static final String DEVELOPER_NOT_FOUND_MESSAGE = "해당 개발자는 존재하지 않습니다.";

    public DeveloperNotFoundException() {
        super(DEVELOPER_NOT_FOUND_MESSAGE, NOT_FOUND);
    }
}
