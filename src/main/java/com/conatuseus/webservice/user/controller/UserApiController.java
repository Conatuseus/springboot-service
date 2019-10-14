package com.conatuseus.webservice.user.controller;

import com.conatuseus.webservice.user.service.UserService;
import com.conatuseus.webservice.user.service.dto.UserSaveRequest;
import com.conatuseus.webservice.user.service.dto.UserUpdateRequest;
import com.conatuseus.webservice.user.service.dto.UserUpdateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/users")
public class UserApiController {

    private final UserService userService;

    public UserApiController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody @Valid UserSaveRequest userSaveRequest) {
        userService.save(userSaveRequest);
        return ResponseEntity.created(URI.create("/loginForm")).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserUpdateResponse> updateUser(@PathVariable Long id, @RequestBody @Valid UserUpdateRequest userUpdateRequest) {
        UserUpdateResponse userUpdateResponse = userService.update(id, userUpdateRequest);
        return ResponseEntity.ok(userUpdateResponse);
    }
}
