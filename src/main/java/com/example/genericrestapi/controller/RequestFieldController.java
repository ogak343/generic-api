package com.example.genericrestapi.controller;

import com.example.genericrestapi.dto.field.CreateRequestField;
import com.example.genericrestapi.dto.field.RequestFieldResponse;
import com.example.genericrestapi.dto.field.UpdateRequestField;
import com.example.genericrestapi.manager.RequestFieldManager;
import io.swagger.v3.oas.annotations.tags.Tag;
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

import static com.example.genericrestapi.constants.ApiConstants.FIELDS_CONTROLLER;
import static com.example.genericrestapi.constants.ApiConstants.FIELDS_URI;

@RestController
@RequestMapping(FIELDS_URI)
@Tag(name = FIELDS_CONTROLLER)
public class RequestFieldController {

    private static final Logger LOG = LoggerFactory.getLogger(RequestFieldController.class);
    private final RequestFieldManager manager;

    public RequestFieldController(RequestFieldManager manager) {
        this.manager = manager;
    }

    @PostMapping
    public ResponseEntity<RequestFieldResponse> create(@RequestBody CreateRequestField request) {

        LOG.info("Create request field: {}", request);
        return ResponseEntity.ok(manager.create(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RequestFieldResponse> update(@PathVariable Long id, @RequestBody UpdateRequestField request) {

        LOG.info("Update request field id: {}, dto: {}", id, request);
        return ResponseEntity.ok(manager.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestFieldResponse> get(@PathVariable Long id) {

        LOG.info("Get request field id: {}", id);
        return ResponseEntity.ok(manager.get(id));
    }

    @GetMapping("/service/{id}")
    public ResponseEntity<List<RequestFieldResponse>> getByServiceId(@PathVariable Long id) {

        LOG.info("Get request field by serviceId: {}", id);
        return ResponseEntity.ok(manager.getByServiceId(id));
    }
}
