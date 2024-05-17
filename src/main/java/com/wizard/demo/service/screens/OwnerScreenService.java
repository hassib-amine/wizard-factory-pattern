package com.wizard.demo.service.screens;

import com.wizard.demo.dto.BaseDTO;
import com.wizard.demo.dto.EtablishmentDTO;
import com.wizard.demo.dto.OwnerDTO;
import com.wizard.demo.dto.WizardScreenDTO;
import com.wizard.demo.enums.WizardScreenEnum;
import com.wizard.demo.service.IWizardScreenService;
import org.springframework.stereotype.Service;

@Service
public class OwnerScreenService implements IWizardScreenService {
    @Override
    public <T extends BaseDTO> T getWizard(Long id) {
        //id -> product table id or category id
        //get info from database  or get another microservice

        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setId(2l);
        ownerDTO.setOwnerName("Owner 1");
        ownerDTO.setOwnerPhone("0606060600");
        ownerDTO.setOwnerEmail("ow@email.com");

        wizardScreenDTO.setOwnerDTO(ownerDTO);

        return (T) wizardScreenDTO;
    }

    @Override
    public <T extends BaseDTO> T createModelWizard(WizardScreenDTO createWizardScreenDTO) {
        OwnerDTO createOwner =createWizardScreenDTO.getOwnerDTO();
        EtablishmentDTO etablishmentDTO = createWizardScreenDTO.getEtablishmentDTO();

        // save product table with category in database or send another service get response

        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        wizardScreenDTO.setEtablishmentDTO(etablishmentDTO);
        wizardScreenDTO.setOwnerDTO(createOwner);

        return (T) wizardScreenDTO;
    }

    @Override
    public <T extends BaseDTO> T updateModelWizard(WizardScreenDTO updateddWizardScreenDTO) {
        OwnerDTO updateOwner = updateddWizardScreenDTO.getOwnerDTO();
        EtablishmentDTO etablishmentDTO = updateddWizardScreenDTO.getEtablishmentDTO();

        //update product with category in database or send another service get response
        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        wizardScreenDTO.setEtablishmentDTO(etablishmentDTO);
        wizardScreenDTO.setOwnerDTO(updateOwner);

        return (T) wizardScreenDTO;
    }

    @Override
    public WizardScreenEnum getScreenName() {
        return WizardScreenEnum.ESTABLISHMENT_OWNER_SCREEN;
    }
}
