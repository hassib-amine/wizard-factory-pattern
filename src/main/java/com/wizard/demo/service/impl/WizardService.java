package com.wizard.demo.service.impl;

import com.wizard.demo.dto.WizardRequestDTO;
import com.wizard.demo.dto.WizardScreenDTO;
import com.wizard.demo.enums.WizardScreenEnum;
import com.wizard.demo.enums.WizardScreenRequestTypeEnum;
import com.wizard.demo.factory.WizardFactoryService;
import com.wizard.demo.service.IWizardScreenService;
import com.wizard.demo.service.IWizardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class WizardService implements IWizardService {
    private final WizardFactoryService wizardFactoryService;

    @Autowired
    public WizardService(WizardFactoryService wizardFactoryService) {
        this.wizardFactoryService = wizardFactoryService;
    }

    @Override
    public ResponseEntity<WizardScreenDTO> postWizard(WizardRequestDTO wizardRequestDTO) {
        IWizardScreenService wizardScreenService =  wizardFactoryService.getScreenWizard(wizardRequestDTO.getWizardScreenEnum());

        if(wizardRequestDTO.getRequestTypeEnum().getRequestType().equals(WizardScreenRequestTypeEnum.CREATE.getRequestType()))
        {
            /**
             * create
             */

            WizardScreenDTO createdDTO =  wizardScreenService.createModelWizard(wizardRequestDTO.getWizardScreenDTO());
            return new ResponseEntity<>(createdDTO, HttpStatus.CREATED);
        }
        else if(wizardRequestDTO.getRequestTypeEnum().getRequestType().equals(WizardScreenRequestTypeEnum.UPDATE.getRequestType()))
        {
            /**
             * update
             */
            WizardScreenDTO updatedDTO = wizardScreenService.updateModelWizard(wizardRequestDTO.getWizardScreenDTO());
            return new ResponseEntity<>(updatedDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>(new WizardScreenDTO(), HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public ResponseEntity<WizardScreenDTO> getWizard(Long id, WizardScreenEnum wizardScreenEnum) {
        if(Objects.nonNull(id))
        {
            IWizardScreenService wizardScreenService =  wizardFactoryService.getScreenWizard(wizardScreenEnum);
            WizardScreenDTO wizardScreenDTO =  wizardScreenService.getWizard(id);

            return new ResponseEntity<>(wizardScreenDTO,HttpStatus.OK);
        }
        return new ResponseEntity<>(new WizardScreenDTO(), HttpStatus.BAD_REQUEST);
    }

}
