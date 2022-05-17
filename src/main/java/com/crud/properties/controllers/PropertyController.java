package com.crud.properties.controllers;


import com.crud.properties.entities.Property;
import com.crud.properties.services.PropertyServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
@Tag(name = "Property", description = "Property Controller")
public class PropertyController {

    @Autowired
    private PropertyServices service;

    @GetMapping

    @Operation(summary = "Get all the properties", description = "Get a list of all the %properties% registered in the system.")
    @ApiResponse(responseCode = "200",description = "Successful Operation.")
    public List<Property> getProperties() {
        return service.findAll();

    }

    @PostMapping
    @Operation(summary = "Create a new property", description = "Insert a new property in the database.")
    @Parameter(required = true)
    public Property addProperty(@RequestBody Property newProperty) {
        return service.addProperty(newProperty);

    }

}