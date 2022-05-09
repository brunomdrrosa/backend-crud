package com.crud.properties.dtos;

import com.crud.properties.entities.Property;
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

    public PropertyDTO(Property propertyDTO) {
        id = propertyDTO.getId();
        address = propertyDTO.getAddress();
        tenant = propertyDTO.getTenant();
        date = propertyDTO.getDate();

    }

}
