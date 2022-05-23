package com.crud.properties.controllers;

import com.crud.properties.entities.Property;
import com.crud.properties.repositories.PropertyRepository;
import com.crud.properties.services.PropertyServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
@Tag(name = "Property", description = "Property Controller")
public class PropertyController {
	
	PropertyRepository PropertyRepository;
	@Autowired
	private PropertyServices service;
	
	@GetMapping("/{id}")
	@Operation(summary = "Get a property by ID", description = "Get a property by ID.")
	public Property getPropertyById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@GetMapping
	@Operation(summary = "Get all the properties", description = "Get a list of all the %properties% registered in the system.")
	@ApiResponse(responseCode = "200", description = "Successful Operation.")
	public List<Property> getProperties() {
		return service.findAll();
	}
	
	@PostMapping
	@Operation(summary = "Create a property", description = "Create a property.")
	@ApiResponse(responseCode = "201", description = "Property created.")
	public Property createProperty(@RequestBody Property property) {
		return service.addProperty(property);
	}
	
	
	@PutMapping("/{id}")
	@Operation(summary = "Update a property", description = "Update a property.")
	@ApiResponse(responseCode = "200", description = "Property updated.")
	public Property updateProperty(@PathVariable Long id, @RequestBody Property newProperty) {
		return service.updateProperty(newProperty);
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Delete a property by ID", description = "Delete a property by ID.")
	@ApiResponse(responseCode = "204", description = "Property deleted.")
	public ResponseEntity<String> deletePropertyById(@PathVariable Long id) {
		service.deleteProperty(id);
		return ResponseEntity.noContent().build();
	}
}