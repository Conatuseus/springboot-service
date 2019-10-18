package com.conatuseus.webservice.developers.controller;

import com.conatuseus.webservice.developers.service.DeveloperService;
import com.conatuseus.webservice.developers.service.dto.DeveloperResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/developers")
public class DeveloperController {

    private static final Logger log = LoggerFactory.getLogger(DeveloperController.class);
    private DeveloperService developerService;

    public DeveloperController(final DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeveloperResponse> findDevelopers(@PathVariable Long id) {
        DeveloperResponse developerResponse = developerService.findDevelopers(id);
        log.debug("developerResponse: {}", developerResponse);
        return ResponseEntity.ok(developerResponse);
    }
}