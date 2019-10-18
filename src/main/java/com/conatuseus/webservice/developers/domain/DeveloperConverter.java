package com.conatuseus.webservice.developers.domain;

import com.conatuseus.webservice.developers.service.dto.DeveloperResponse;

public class DeveloperConverter {

    public static DeveloperResponse toResponse(Developer developer) {
        return DeveloperResponse.builder()
            .name(developer.getName())
            .monitor(developer.getMonitor())
            .keyboard(developer.getKeyboard())
            .mouse(developer.getMouse())
            .notebook(developer.getNotebook())
            .build();
    }
}
