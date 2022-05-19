package com.crud.properties.repositories;

import com.crud.properties.entities.Property;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<Property, Long> {}
