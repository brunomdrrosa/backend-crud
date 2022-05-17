package com.crud.properties.repositories;

import com.crud.properties.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PropertyRepository extends JpaRepository<Property,Long> {

}
