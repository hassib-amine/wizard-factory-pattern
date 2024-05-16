package com.wizard.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = false)
public class EtablishmentDTO extends BaseDTO {

    private String name;
    private String type;
    private String description;

}
