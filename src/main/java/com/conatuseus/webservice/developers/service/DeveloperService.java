package com.conatuseus.webservice.developers.service;

import com.conatuseus.webservice.developers.domain.Developer;
import com.conatuseus.webservice.developers.domain.DeveloperConverter;
import com.conatuseus.webservice.developers.domain.DeveloperRepository;
import com.conatuseus.webservice.developers.service.dto.DeveloperRequest;
import com.conatuseus.webservice.developers.service.dto.DeveloperResponse;
import com.conatuseus.webservice.developers.service.exception.DeveloperNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void saveDeveloper(final DeveloperRequest developerRequest) {
        developerRepository.save(developerRequest.toEntity());
    }

    @Transactional
    public DeveloperResponse update(final Long id, final DeveloperRequest developerRequest) {
        Developer developer = developerRepository.findById(id)
            .orElseThrow(DeveloperNotFoundException::new);

        developer.update(developerRequest);
        return developer.toResponse();
    }

    @Transactional
    public void delete(final Long id) {
        developerRepository.deleteById(id);
    }
}
