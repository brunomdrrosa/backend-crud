package com.crud.properties.services;

import com.crud.properties.dtos.PropertyDTO;
import com.crud.properties.entities.Property;
import com.crud.properties.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class PropertyServices {

    @Autowired
    private PropertyRepository repository;

   @Transactional(readOnly = true)
    public List<Property> findAll() {
       return repository.findAll();
    }

    public Property addProperty(Property newProperty){
       return repository.saveAndFlush(newProperty);
    }

    public PropertyDTO updateProperty(PropertyDTO propertyDTO) {

       Property property = new Property();
       property.setId(propertyDTO.getId());
       property.setTenant(propertyDTO.getTenant());
       property.setAddress(propertyDTO.getAddress());
       property.setDate(propertyDTO.getDate());

       property = repository.saveAndFlush(property);

       return new PropertyDTO(property);
    }
}