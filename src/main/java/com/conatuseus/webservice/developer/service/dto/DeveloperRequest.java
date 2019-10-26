package com.conatuseus.webservice.developer.service.dto;

import com.conatuseus.webservice.developer.domain.Developer;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class DeveloperRequest {

    @NotBlank(message = "이름을 입력해 주세요.")
    private String name;

    private String notebook;

    private String monitor;

    private String keyboard;

    private String mouse;

    @Builder
    public DeveloperRequest(final String name, final String notebook, final String monitor, final String keyboard, final String mouse) {
        this.name = name;
        this.notebook = notebook;
        this.monitor = monitor;
        this.keyboard = keyboard;
        this.mouse = mouse;
    }

    public Developer toEntity() {
        return Developer.builder()
            .name(name)
            .notebook(notebook)
            .monitor(monitor)
            .keyboard(keyboard)
            .mouse(mouse)
            .build();
    }
}
