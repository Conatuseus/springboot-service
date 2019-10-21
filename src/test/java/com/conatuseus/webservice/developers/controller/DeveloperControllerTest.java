package com.conatuseus.webservice.developers.controller;

import com.conatuseus.webservice.developers.service.dto.DeveloperRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@AutoConfigureWebTestClient
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DeveloperControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void findDeveloper() {
        webTestClient.get()
            .uri("/api/developers/1")
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$.name").isEqualTo("testName")
            .jsonPath("$.keyboard").isEqualTo("testKeyboard")
            .jsonPath("$.monitor").isEqualTo("testMonitor");
    }

    @Test
    public void saveDeveloper() {
        DeveloperRequest requestDto = new DeveloperRequest();
        requestDto.setName("conatuseus");
        webTestClient.post()
            .uri("/api/developers")
            .body(Mono.just(requestDto), DeveloperRequest.class)
            .exchange()
            .expectStatus().isCreated();
    }
}
