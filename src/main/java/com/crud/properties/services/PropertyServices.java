package com.crud.properties.services;

import com.crud.properties.entities.Property;
import com.crud.properties.repositories.PropertyRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    
    

    public Property addProperty(Property newProperty){
       return repository.save(newProperty);
    }
    
    public Property updateProperty(Property updatedProperty){
        return repository.save(updatedProperty);
    }


}