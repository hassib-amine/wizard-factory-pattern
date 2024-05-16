package com.wizard.demo.service;

import com.wizard.demo.dto.BaseDTO;
import com.wizard.demo.dto.WizardRequestDTO;
import com.wizard.demo.dto.WizardScreenDTO;
import com.wizard.demo.enums.WizardScreenEnum;

public interface IWizardScreenService {
    <T extends BaseDTO> T getWizard(Long id);
    <T extends BaseDTO> T createModelWizard(WizardScreenDTO createWizardScreenDTO);
    <T extends BaseDTO> T updateModelWizard(WizardScreenDTO updateddWizardScreenDTO);
    WizardScreenEnum getScreenName();
}
