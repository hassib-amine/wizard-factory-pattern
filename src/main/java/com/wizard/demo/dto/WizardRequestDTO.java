package com.wizard.demo.dto;

import com.wizard.demo.enums.WizardScreenEnum;
import com.wizard.demo.enums.WizardScreenRequestTypeEnum;
import lombok.Data;

import java.io.Serializable;
@Data
public class WizardRequestDTO implements Serializable {
    /*
        sceeenEnum : It specifies which screen we will manage.
        requestTypeEnum : Indicates whether the request is a create or update.
        wizardScreenDTO : DTO that wraps the DTO that contains the information of the related screen
    */
    private WizardScreenEnum wizardScreenEnum;
    private WizardScreenRequestTypeEnum requestTypeEnum;
    private WizardScreenDTO wizardScreenDTO;

}
