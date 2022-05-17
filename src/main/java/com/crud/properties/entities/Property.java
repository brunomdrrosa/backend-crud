package com.crud.properties.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "db_properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Name of the tenant.",
            example = "Jessica Abigail", required = true)
    @NotBlank
    @Size(min= 1, max = 100)
    private String tenant;

    @Schema(description = "Address line 1 of the contact.",
            example = "888 Constantine Ave, #54", required = true)
    @Size(min= 1, max = 150)
    private String address;

    @Schema(description = "Date of register",
            example = "2021-01-30T08:30:00Z", required = true)
     private Date date;

}
