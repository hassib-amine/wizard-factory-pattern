package com.wizard.demo.service;

import com.wizard.demo.dto.WizardRequestDTO;
import com.wizard.demo.dto.WizardScreenDTO;
import com.wizard.demo.enums.WizardScreenEnum;
import org.springframework.http.ResponseEntity;

public interface IWizardService {
    ResponseEntity<WizardScreenDTO> postWizard(WizardRequestDTO wizardRequestDTO);
    ResponseEntity<WizardScreenDTO> getWizard(Long id, WizardScreenEnum wizardScreenEnum);


}
