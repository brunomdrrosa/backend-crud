package com.crud.properties.services;

import com.crud.properties.entities.Property;
import com.crud.properties.repositories.PropertyRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PropertyServices {

   @Autowired
   private PropertyRepository repository;

   @Transactional
   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   public List<Property> findAll() {
       return (List<Property>) repository.findAll();
   }

   public Property addProperty(Property newProperty) {
       return repository.save(newProperty);
   }

   public Property updateProperty(@NotNull Property updatedProperty) {
      if (repository.existsById(updatedProperty.getId())) {
          return repository.save(updatedProperty);
      } else {
          throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Property not found for this id");
      }
   }

    public ResponseEntity deleteProperty(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Property deleted");
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Property not found for this id");
    }

    public Property findById(Long id) {
        if (repository.existsById(id)) {
            return repository.findById(id).get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Property not found for this id");
    }

}