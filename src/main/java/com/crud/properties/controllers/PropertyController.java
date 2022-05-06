package com.crud.properties.controllers;


import com.crud.properties.dtos.PropertyDTO;
import com.crud.properties.entities.Property;
import com.crud.properties.services.PropertyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyServices service;

    @GetMapping
    public List<Property> getProperties() {
        return service.findAll();

    }
}