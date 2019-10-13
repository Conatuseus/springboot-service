package com.conatuseus.webservice.user.service;

import com.conatuseus.webservice.user.domain.User;
import com.conatuseus.webservice.user.domain.UserConverter;
import com.conatuseus.webservice.user.domain.UserRepository;
import com.conatuseus.webservice.user.service.dto.UserSaveRequestDto;
import com.conatuseus.webservice.user.service.dto.UserSaveResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserSaveService {

    private final UserRepository userRepository;

    public UserSaveService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserSaveResponseDto save(final UserSaveRequestDto userSaveRequestDto) {
        User user = userRepository.save(userSaveRequestDto.toEntity());
        return UserConverter.toSaveResponse(user);
    }
}
