package com.conatuseus.webservice.developers.domain;

import com.conatuseus.webservice.developers.service.dto.DeveloperRequest;
import com.conatuseus.webservice.developers.service.dto.DeveloperResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String notebook;

    @Column
    private String monitor;

    @Column
    private String keyboard;

    @Column
    private String mouse;

    @Builder
    public Developer(final String name, final String notebook, final String monitor, final String keyboard, final String mouse) {
        this.name = name;
        this.notebook = notebook;
        this.monitor = monitor;
        this.keyboard = keyboard;
        this.mouse = mouse;
    }

    public void update(final DeveloperRequest developerRequest) {
        this.name = developerRequest.getName();
        this.notebook = developerRequest.getNotebook();
        this.monitor = developerRequest.getNotebook();
        this.keyboard = developerRequest.getKeyboard();
        this.mouse = developerRequest.getMouse();
    }

    public DeveloperResponse toResponse() {
        return DeveloperResponse.builder()
            .name(name)
            .notebook(notebook)
            .monitor(monitor)
            .keyboard(keyboard)
            .mouse(mouse)
            .build();
    }
}
