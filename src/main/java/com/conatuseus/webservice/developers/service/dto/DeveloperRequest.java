package com.conatuseus.webservice.developers.service.dto;

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
}
