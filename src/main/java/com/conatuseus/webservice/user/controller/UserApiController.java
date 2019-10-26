package com.conatuseus.webservice.user.controller;

import com.conatuseus.webservice.user.service.UserService;
import com.conatuseus.webservice.user.service.dto.UserResponse;
import com.conatuseus.webservice.user.service.dto.UserSaveRequest;
import com.conatuseus.webservice.user.service.dto.UserUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> readUser(@PathVariable Long id) {
        UserResponse userResponse = userService.readUser(id);
        return ResponseEntity.ok(userResponse);
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody @Valid UserSaveRequest userSaveRequest) {
        userService.save(userSaveRequest);
        return ResponseEntity.created(URI.create("/loginForm")).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody @Valid UserUpdateRequest userUpdateRequest) {
        UserResponse userUpdateResponse = userService.update(id, userUpdateRequest);
        return ResponseEntity.ok(userUpdateResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
