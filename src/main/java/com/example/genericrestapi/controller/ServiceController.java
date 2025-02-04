package com.example.genericrestapi.controller;

import com.example.genericrestapi.dto.service.CreateService;
import com.example.genericrestapi.dto.service.ServiceResponse;
import com.example.genericrestapi.dto.service.UpdateService;
import com.example.genericrestapi.manager.ServiceManager;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.genericrestapi.constants.ApiConstants.SERVICES_CONTROLLER;
import static com.example.genericrestapi.constants.ApiConstants.SERVICES_URI;

@RestController
@RequestMapping(SERVICES_URI)
@Tag(name = SERVICES_CONTROLLER)
public class ServiceController {

    private static final Logger LOG = LoggerFactory.getLogger(ServiceController.class);
    private final ServiceManager manager;

    public ServiceController(ServiceManager manager) {
        this.manager = manager;
    }

    @PostMapping
    public ResponseEntity<ServiceResponse> create(@RequestBody @Valid CreateService request) {

        LOG.info("Create service: {}", request);
        return ResponseEntity.ok(manager.create(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ServiceResponse> update(@PathVariable Long id, @RequestBody @Valid UpdateService request) {

        LOG.info("Update service: {}", request);
        return ResponseEntity.ok(manager.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResponse> get(@PathVariable Long id) {

        LOG.info("Get service: {}", id);
        return ResponseEntity.ok(manager.get(id));
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<List<ServiceResponse>> getByCompanyId(@PathVariable Long id) {

        LOG.info("Get services by companyId: {}", id);
        return ResponseEntity.ok(manager.getByCompanyId(id));
    }
}

