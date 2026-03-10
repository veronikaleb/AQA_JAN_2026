package org.prog.session16.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PersonDto {
    private String gender;
    private String nat;
    private NameDto name;
    private LocationDto location;
}
