package com.wizard.demo.service.screens;

import com.wizard.demo.dto.BaseDTO;
import com.wizard.demo.dto.EtablishmentDTO;
import com.wizard.demo.dto.WizardScreenDTO;
import com.wizard.demo.enums.WizardScreenEnum;
import com.wizard.demo.service.IWizardScreenService;
import org.springframework.stereotype.Service;

@Service
public class EtablishmentScreenService implements IWizardScreenService {
    @Override
    public <T extends BaseDTO> T getWizard(Long id) {

        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        EtablishmentDTO etablishmentDTO = createEtablishmentDTO(id);

        wizardScreenDTO.setEtablishmentDTO(etablishmentDTO);
        return (T) wizardScreenDTO;
    }

    @Override
    public <T extends BaseDTO> T createModelWizard(WizardScreenDTO createWizardScreenDTO) {

        EtablishmentDTO etablishmentDTO = createWizardScreenDTO.getEtablishmentDTO();

        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        EtablishmentDTO createEtablishmentDTO = saveEtablishmentDTO(etablishmentDTO);

        wizardScreenDTO.setEtablishmentDTO(createEtablishmentDTO);

        return (T) wizardScreenDTO;
    }

    @Override
    public <T extends BaseDTO> T updateModelWizard(WizardScreenDTO updateWizardScreenDTO) {
        EtablishmentDTO etablishmentDTO = updateWizardScreenDTO.getEtablishmentDTO();
        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        EtablishmentDTO updateEtablishmentDTO = updateEtablishmentDTO(etablishmentDTO);

        wizardScreenDTO.setEtablishmentDTO(updateEtablishmentDTO);
        return (T) wizardScreenDTO;
    }

    @Override
    public WizardScreenEnum getScreenName() {
        return WizardScreenEnum.ESTABLISHMENT_INFO_SCREEN;
    }

    private EtablishmentDTO createEtablishmentDTO(Long id) {

        EtablishmentDTO etablishmentDTO = new EtablishmentDTO();
        etablishmentDTO.setId(id);
        etablishmentDTO.setName("product 1");
        etablishmentDTO.setType("p1");
        etablishmentDTO.setDescription("product1 title");

        return etablishmentDTO;
    }

    private EtablishmentDTO saveEtablishmentDTO(EtablishmentDTO etablishmentDTO) {

        EtablishmentDTO createdDTO = new EtablishmentDTO();
        createdDTO.setName(etablishmentDTO.getName());
        createdDTO.setType(etablishmentDTO.getType());
        createdDTO.setDescription(etablishmentDTO.getDescription());

        //save database
        createdDTO.setId(2l);
        return createdDTO;
    }

    private EtablishmentDTO updateEtablishmentDTO(EtablishmentDTO etablishmentDTO) {
        //update database
        return etablishmentDTO;
    }
}
