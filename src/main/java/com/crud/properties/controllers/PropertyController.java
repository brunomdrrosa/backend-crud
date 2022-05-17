package com.crud.properties.controllers;


import com.crud.properties.dtos.PropertyDTO;
import com.crud.properties.entities.Property;
import com.crud.properties.repositories.PropertyRepository;
import com.crud.properties.services.PropertyServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/properties")
@Tag(name = "Property", description = "Property Controller")
public class PropertyController {

    @Autowired
    private PropertyServices service;

    private PropertyRepository repository;

    @GetMapping

    @Operation(summary = "Get all the properties", description = "Get a list of all the %properties% registered in the system.")
    @ApiResponse(responseCode = "200",description = "Successful Operation.")
    public List<Property> getProperties() {
        return service.findAll();
    }

    @PostMapping
    @Operation(summary = "Create a new property", description = "Insert a new property in the database.")
    public Property addProperty(@RequestBody Property newProperty) {
        return service.addProperty(newProperty);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a new property", description = "Update a new property in the database.")
    public PropertyDTO updateProperty(@RequestBody PropertyDTO dto) {
        return service.updateProperty(dto);
    }
}