package com.crud.properties.controllers;


import com.crud.properties.entities.Property;
import com.crud.properties.repositories.PropertyRepository;
import com.crud.properties.services.PropertyServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/properties")
@Tag(name = "Property", description = "Property Controller")
public class PropertyController {
    
    PropertyRepository PropertyRepository;
    @Autowired
    private PropertyServices service;

    @GetMapping

    @Operation(summary = "Get all the properties", description = "Get a list of all the %properties% registered in the system.")
    @ApiResponse(responseCode = "200",description = "Successful Operation.")
    public List<Property> getProperties() {
        return service.findAll();

    }
    @PutMapping("/{id}")
    @Operation(summary = "Update a new property", description = "Update a new property in the database.")
    public Property updateProperty(@PathVariable Long id, @RequestBody Property newProperty) {
        
        return service.updateProperty(newProperty);
        
    }
    

    @PostMapping
    @Operation(summary = "Create a new property", description = "Insert a new property in the database.")
    @Parameter(required = true)
    public Property addProperty(@RequestBody Property newProperty) {
        List<Property> listProperties = service.findAll();
        for (Property property : listProperties) {
            System.out.println(listProperties);
            if (property.getId().equals(property.getId())) {
                return service.updateProperty(newProperty);
            }else {
                System.out.println("Property does not exists");
            }
        }
//        try {
//
//        } catch
//        (Exception e) {}
//
        //return service.addProperty(newProperty);

    
    
  
    
    
    
    
   
  
   
//    @PutMapping("/{id}")
//    @Transactional
//    public ResponseEntity<PropertyDTO> update(@PathVariable Long id,
//                                              @RequestBody @Valid UpdatePropertyForm form) {
//        Optional<Property> optional = PropertyRepository.findById(id);
//        if (optional.isPresent()) {
//
//            Property property1 = form.update(id, PropertyRepository);
//            return ResponseEntity.ok(new PropertyDTO(property1));
//        }
//
//        return ResponseEntity.notFound().build();
//    }
    
        return newProperty;
    }
}