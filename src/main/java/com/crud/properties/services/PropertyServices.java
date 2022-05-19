package com.crud.properties.services;

import com.crud.properties.entities.Property;
import com.crud.properties.repositories.PropertyRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PropertyServices {
<<<<<<< Updated upstream
    @Autowired
    private PropertyRepository repository;
   @Transactional
   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   public List<Property> findAll() {
       return (List<Property>) repository.findAll();
    }
    
    public Property addProperty(Property newProperty){
       return repository.save(newProperty);
=======
  @Autowired private PropertyRepository repository;

  @Transactional
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  public List<Property> findAll() {
    return (List<Property>) repository.findAll();
  }

  public Property addProperty(Property newProperty) {

    if (repository.existsById(newProperty.getId())) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "Property already exists for this id");
    } else {
      return repository.save(newProperty);
>>>>>>> Stashed changes
    }
  }

  public Property updateProperty(@NotNull Property updatedProperty) {
    if (repository.existsById(updatedProperty.getId())) {
      return repository.save(updatedProperty);
    } else {
<<<<<<< Updated upstream
        return null;
       }
   }
    
    public void deleteProperty(Long id){
        repository.deleteById(id);
    }
    
    public Property findById(Long id){
        return repository.findById(id).get();
    }
}
=======
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
>>>>>>> Stashed changes
