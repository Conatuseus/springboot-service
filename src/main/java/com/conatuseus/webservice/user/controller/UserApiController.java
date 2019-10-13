package com.conatuseus.webservice.user.controller;

import com.conatuseus.webservice.user.service.UserSaveService;
import com.conatuseus.webservice.user.service.dto.UserSaveRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/users")
public class UserApiController {

    private final UserSaveService userSaveService;

    public UserApiController(final UserSaveService userSaveService) {
        this.userSaveService = userSaveService;
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody @Valid UserSaveRequestDto userSaveRequestDto) {
        userSaveService.save(userSaveRequestDto);
        return ResponseEntity.created(URI.create("/loginForm")).build();
    }
//    @RequestMapping
//    public ResponseEntity
}
