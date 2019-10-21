package com.conatuseus.webservice.user.controller;

import com.conatuseus.webservice.user.service.dto.UserReadResponse;
import com.conatuseus.webservice.user.service.dto.UserSaveRequest;
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
    public void readUser() {

        UserReadResponse userReadResponse = new UserReadResponse("testEmail@gmail.com", "testPassword", "testName", "01099996384");
        webTestClient.get()
            .uri("/api/users/1")
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$.email").isEqualTo("testEmail@gmail.com")
            .jsonPath("$.name").isEqualTo("testName")
            .jsonPath("$.password").isEqualTo("testPassword")
            .jsonPath("$.phoneNumber").isEqualTo("01099996384");
    }

    @Test
    public void saveUser() {
        UserSaveRequest userSaveRequest = new UserSaveRequest("conatuseus@gmail.com", "1234", "conas", "01099996384");
        webTestClient.post()
            .uri("/api/users")
            .body(Mono.just(userSaveRequest), UserSaveRequest.class)
            .exchange()
            .expectStatus().isCreated();
    }

    @Test
    public void updateUser() {

    }

}
