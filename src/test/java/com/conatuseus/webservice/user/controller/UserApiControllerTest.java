package com.conatuseus.webservice.user.controller;

import com.conatuseus.webservice.user.service.dto.UserSaveRequestDto;
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
public class UserApiControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void createUser() {
        UserSaveRequestDto userSaveRequestDto = new UserSaveRequestDto("conatuseus@gmail.com", "1234", "conas", "01099996384");
        webTestClient.post()
            .uri("/api/users")
            .body(Mono.just(userSaveRequestDto), UserSaveRequestDto.class)
            .exchange()
            .expectStatus().isCreated();
    }
}