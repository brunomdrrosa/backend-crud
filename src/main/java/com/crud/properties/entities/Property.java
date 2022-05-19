package com.crud.properties.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
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

  @Schema(description = "Name of the tenant.", example = "Michael Scott", required = true)
  @NotBlank
  @Size(min = 1, max = 100)
  private String tenant;

  @Schema(
      description = "Address line 1 of the contact.",
      example = "1725 Slough Avenue in Scranton, PA.",
      required = true)
  @Size(min = 1, max = 150)
  private String address;

  @Schema(description = "Date of register", example = "2009-01-02T08:30:00Z", required = true)
  private Date date;
}
