package com.conatuseus.webservice.developers.service;

import com.conatuseus.webservice.developers.domain.Developer;
import com.conatuseus.webservice.developers.domain.DeveloperConverter;
import com.conatuseus.webservice.developers.domain.DeveloperRepository;
import com.conatuseus.webservice.developers.service.dto.DeveloperResponse;
import com.conatuseus.webservice.developers.service.exception.DeveloperNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DeveloperService {

    private DeveloperRepository developerRepository;

    public DeveloperService(final DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public DeveloperResponse findDevelopers(final Long id) {
        Developer developer = developerRepository.findById(id)
            .orElseThrow(DeveloperNotFoundException::new);

        return DeveloperConverter.toResponse(developer);
    }
}
