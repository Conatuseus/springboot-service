package com.conatuseus.webservice.developers.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeveloperResponse {

    private String name;
    private String notebook;
    private String monitor;
    private String keyboard;
    private String mouse;

    @Builder
    public DeveloperResponse(final String name, final String notebook, final String monitor, final String keyboard, final String mouse) {
        this.name = name;
        this.notebook = notebook;
        this.monitor = monitor;
        this.keyboard = keyboard;
        this.mouse = mouse;
    }
}
