package com.crud.properties.services;

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
        List<Property> lista = repository.findAll();
       return lista;
    }

    public Property addProperty(Property newProperty){
       return repository.saveAndFlush(newProperty);
    }


}