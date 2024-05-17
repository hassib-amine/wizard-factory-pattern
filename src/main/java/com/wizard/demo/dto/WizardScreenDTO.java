package com.wizard.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.LinkedList;
import java.util.List;
@Data
@EqualsAndHashCode(callSuper = false)
public class WizardScreenDTO extends BaseDTO{
    private EtablishmentDTO etablishmentDTO;
    private LocationDTO locationDTO;
    private ContactDTO contactDTO;
    private OwnerDTO ownerDTO;
    private List<SpecificationDTO> specificationDTOList = new LinkedList<>();

    @Override
    @JsonIgnore
    public Long getId() {
        return super.getId();
    }
}
