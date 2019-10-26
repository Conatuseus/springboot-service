package com.conatuseus.webservice.user.service;

import com.conatuseus.webservice.user.domain.User;
import com.conatuseus.webservice.user.domain.UserConverter;
import com.conatuseus.webservice.user.domain.UserRepository;
import com.conatuseus.webservice.user.service.dto.UserResponse;
import com.conatuseus.webservice.user.service.dto.UserSaveRequest;
import com.conatuseus.webservice.user.service.dto.UserUpdateRequest;
import com.conatuseus.webservice.user.service.exception.UserNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserResponse save(final UserSaveRequest userSaveRequest) {
        User user = userRepository.save(userSaveRequest.toEntity());
        return UserConverter.toResponse(user);
    }

    @Transactional
    public UserResponse update(final Long id, final UserUpdateRequest userUpdateRequest) {
        User user = userRepository.findById(id)
            .orElseThrow(UserNotFoundException::new);
        user.update(userUpdateRequest);
        return UserConverter.toResponse(user);
    }

    public UserResponse readUser(final Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(UserNotFoundException::new);
        return UserConverter.toResponse(user);
    }

    @Transactional
    public void deleteById(final Long id) {
        if (isUserNotExist(id)) {
            throw new UserNotFoundException();
        }
        userRepository.deleteById(id);
    }

    private boolean isUserNotExist(final Long id) {
        return !userRepository.findById(id).isPresent();
    }
}
