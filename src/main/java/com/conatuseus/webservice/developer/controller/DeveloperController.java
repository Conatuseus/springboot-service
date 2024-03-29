package com.conatuseus.webservice.developer.controller;

import com.conatuseus.webservice.developer.service.DeveloperService;
import com.conatuseus.webservice.developer.service.dto.DeveloperRequest;
import com.conatuseus.webservice.developer.service.dto.DeveloperResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @PostMapping
    public ResponseEntity saveDeveloper(@RequestBody @Valid DeveloperRequest developerRequest) {
        developerService.saveDeveloper(developerRequest);

        return ResponseEntity.created(URI.create("/developers")).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeveloperResponse> updateDeveloper(@PathVariable Long id, @RequestBody @Valid DeveloperRequest developerRequest) {
        DeveloperResponse developerResponse = developerService.update(id, developerRequest);
        return ResponseEntity.ok(developerResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDeveloper(@PathVariable Long id) {
        developerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
