package com.wizard.demo.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class SpecificationDTO extends BaseDTO{
    private String operatingHours;
    private LocalDate registrationDate;
    private String status;
}

