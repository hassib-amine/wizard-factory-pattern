package com.wizard.demo.service.screens;

import com.wizard.demo.dto.BaseDTO;
import com.wizard.demo.dto.ContactDTO;
import com.wizard.demo.dto.EtablishmentDTO;
import com.wizard.demo.dto.WizardScreenDTO;
import com.wizard.demo.enums.WizardScreenEnum;
import com.wizard.demo.service.IWizardScreenService;
import org.springframework.stereotype.Service;

@Service
public class ContactScreenService implements IWizardScreenService {
    @Override
    public <T extends BaseDTO> T getWizard(Long id) {

        //get info from database  or get another microservice

        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(100l);
        contactDTO.setEmail("Company 100");
        contactDTO.setPhoneNumber("0522222223");

        wizardScreenDTO.setContactDTO(contactDTO);

        return (T) wizardScreenDTO;
    }

    @Override
    public <T extends BaseDTO> T createModelWizard(WizardScreenDTO createWizardScreenDTO) {
        ContactDTO createContact = createWizardScreenDTO.getContactDTO();
        EtablishmentDTO etablishmentDTO = createWizardScreenDTO.getEtablishmentDTO();

        // save product table with category in database or send another service get response

        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        wizardScreenDTO.setContactDTO(createContact);
        wizardScreenDTO.setEtablishmentDTO(etablishmentDTO);

        return (T) wizardScreenDTO;
    }

    @Override
    public <T extends BaseDTO> T updateModelWizard(WizardScreenDTO updateddWizardScreenDTO) {
        ContactDTO updateContact= updateddWizardScreenDTO.getContactDTO();
        EtablishmentDTO etablishmentDTO = updateddWizardScreenDTO.getEtablishmentDTO();

        //update product with category in database or send another service get response
        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        wizardScreenDTO.setEtablishmentDTO(etablishmentDTO);
        wizardScreenDTO.setContactDTO(updateContact);

        return (T) wizardScreenDTO;
    }

    @Override
    public WizardScreenEnum getScreenName() {
        return WizardScreenEnum.ESTABLISHMENT_CONTACT_SCREEN;
    }
}
