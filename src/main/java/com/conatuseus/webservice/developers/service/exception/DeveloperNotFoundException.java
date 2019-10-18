package com.conatuseus.webservice.developers.service.exception;

public class DeveloperNotFoundException extends RuntimeException {

    private static final String DEVELOPER_NOT_FOUND_MESSAGE = "해당 개발자는 존재하지 않습니다.";

    public DeveloperNotFoundException() {
        super(DEVELOPER_NOT_FOUND_MESSAGE);
    }
}
