package com.wizard.demo.dto;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;
@Data
public class WizardScreenDTO extends BaseDTO{
    private EtablishmentDTO etablishmentDTO;
    private LocationDTO locationDTO;
    private ContactDTO contactDTO;
    private OwnerDTO ownerDTO;
    private List<SpecificationDTO> specificationDTOList = new LinkedList<>();
}
