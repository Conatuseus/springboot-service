package com.conatuseus.webservice.developers.controller;

import com.conatuseus.webservice.developers.service.dto.DeveloperRequest;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("유효하지 않는 developer 검색")
    public void find_invalid_developer() {
        webTestClient.get()
            .uri("/api/developers/987654321")
            .exchange()
            .expectStatus().isNotFound();
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

    @Test
    @DisplayName("이름이 없는 developer 저장 검사")
    public void save_none_name_Developer() {
        DeveloperRequest requestDto = new DeveloperRequest();
        webTestClient.post()
            .uri("/api/developers")
            .body(Mono.just(requestDto), DeveloperRequest.class)
            .exchange()
            .expectStatus().isBadRequest();
    }

    @Test
    @DisplayName("개발자 정보 변경")
    public void updateDeveloper() {
        DeveloperRequest requestDto = DeveloperRequest.builder()
            .name("conatuseus")
            .keyboard("PD-KB600B")
            .build();

        webTestClient.put()
            .uri("/api/developers/2")
            .body(Mono.just(requestDto), DeveloperRequest.class)
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$.name").isEqualTo("conatuseus")
            .jsonPath("$.keyboard").isEqualTo("PD-KB600B");
    }

    @Test
    @DisplayName("유효하지 않은 개발자 정보 변경")
    public void update_invalid_developer() {
        DeveloperRequest requestDto = DeveloperRequest.builder()
            .name("conatuseus")
            .keyboard("PD-KB600B")
            .build();

        webTestClient.put()
            .uri("/api/developers/987654321")
            .body(Mono.just(requestDto), DeveloperRequest.class)
            .exchange()
            .expectStatus().isNotFound();
    }

    @Test
    @DisplayName("developer 잘 삭제되는 경우")
    public void deleteDeveloper() {
        webTestClient.delete()
            .uri("/api/developers/3")
            .exchange()
            .expectStatus().isOk();

        webTestClient.get()
            .uri("/api/developers/3")
            .exchange()
            .expectStatus().isNotFound();
    }

    @Test
    @DisplayName("유효하지 않는 Developer 삭제 요청")
    public void delete_invalid_Developer() {
        webTestClient.delete()
            .uri("/api/developer/987654321")
            .exchange()
            .expectStatus().isNotFound();
    }

}
