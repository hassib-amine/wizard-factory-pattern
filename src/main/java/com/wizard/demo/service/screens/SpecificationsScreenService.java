package com.wizard.demo.service.screens;

import com.wizard.demo.dto.BaseDTO;
import com.wizard.demo.dto.EtablishmentDTO;
import com.wizard.demo.dto.SpecificationDTO;
import com.wizard.demo.dto.WizardScreenDTO;
import com.wizard.demo.enums.WizardScreenEnum;
import com.wizard.demo.service.IWizardScreenService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
@Service
public class SpecificationsScreenService implements IWizardScreenService {
    @Override
    public <T extends BaseDTO> T getWizard(Long id) {
        //id -> product table id
        //get info from database with  or another microservice

        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        List<SpecificationDTO> specificationDTOList = createEtablishmentSpecificationList();
        wizardScreenDTO.setSpecificationDTOList(specificationDTOList);

        return (T) wizardScreenDTO;
    }


    @Override
    public <T extends BaseDTO> T createModelWizard(WizardScreenDTO createWizardScreenDTO) {
        EtablishmentDTO etablishmentDTO = createWizardScreenDTO.getEtablishmentDTO();

        List<SpecificationDTO> createSpecificationDTOList =  createWizardScreenDTO.getSpecificationDTOList();

        AtomicLong counter = new AtomicLong(100);

        createSpecificationDTOList.forEach(specificationDTO -> {
            specificationDTO.setId(counter.getAndIncrement());
        });

        //save product specification table with createSpecificationDTOList

        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        wizardScreenDTO.setEtablishmentDTO(etablishmentDTO);
        wizardScreenDTO.setSpecificationDTOList(createSpecificationDTOList);

        return (T) wizardScreenDTO;
    }

    @Override
    public <T extends BaseDTO> T updateModelWizard(WizardScreenDTO updateddWizardScreenDTO) {
        EtablishmentDTO etablishmentDTO = updateddWizardScreenDTO.getEtablishmentDTO();

        List<SpecificationDTO> updateSpecificationDTOList =  updateddWizardScreenDTO.getSpecificationDTOList();

        //update product specification table with updateSpecificationDTOList

        updateSpecificationDTOList.forEach(specificationDTO -> {

            specificationDTO.setStatus(specificationDTO + " updated");
            specificationDTO.setOperatingHours(specificationDTO + " updated");
        });

        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        wizardScreenDTO.setEtablishmentDTO(etablishmentDTO);
        wizardScreenDTO.setSpecificationDTOList(updateSpecificationDTOList);

        return (T) wizardScreenDTO;
    }

    @Override
    public WizardScreenEnum getScreenName() {
        return WizardScreenEnum.ESTABLISHMENT_SPECIFICATION_SCREEN;
    }
    private List<SpecificationDTO> createEtablishmentSpecificationList() {
        List<SpecificationDTO> list = new ArrayList<>();

        SpecificationDTO dto1 = createSpecificationDTO(300l,"spec 1");
        SpecificationDTO dto2 = createSpecificationDTO(400l,"spec 2");

        list.add(dto1);
        list.add(dto2);

        return list;
    }

    private SpecificationDTO createSpecificationDTO(Long specId, String specName) {

        SpecificationDTO dto = new SpecificationDTO();
        dto.setId(specId);
        dto.setStatus(specName);
        dto.setOperatingHours(specName);

        return dto;
    }
}
