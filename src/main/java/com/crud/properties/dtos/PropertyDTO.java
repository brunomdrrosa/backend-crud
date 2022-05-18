package com.crud.properties.dtos;

import com.crud.properties.entities.Property;
import com.crud.properties.repositories.PropertyRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PropertyDTO {
    private Long id;
    private String tenant;
    private String address;
    private Date date;
    private Property property;
    
    public PropertyDTO(Property propertyDTO) {
        id = propertyDTO.getId();
        address = propertyDTO.getAddress();
        tenant = propertyDTO.getTenant();
        date = propertyDTO.getDate();

    }
    
    public Property updateProperty(Long id, PropertyRepository propertyRepository) {
        Property property = propertyRepository.findById(id).get();
    
        property.setId(this.id);
        property.setAddress(this.address);
        property.setTenant(this.tenant);
        property.setDate(this.date);
        
        return this.property;
    }
    
    

}
