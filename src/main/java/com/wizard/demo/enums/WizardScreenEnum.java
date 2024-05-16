package com.wizard.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WizardScreenEnum {

    ESTABLISHMENT_INFO_SCREEN(1, "EstablishmentInfo", "Entering basic info of establishment"),
    ESTABLISHMENT_LOCATION_SCREEN(2, "EstablishmentLocation", "Entering location info of establishment"),
    ESTABLISHMENT_CONTACT_SCREEN(3, "EstablishmentContact", "Entering contact info of establishment"),
    ESTABLISHMENT_OWNER_SCREEN(4, "EstablishmentOwner", "Entering owner info of establishment"),
    ESTABLISHMENT_SPECIFICATION_SCREEN(5, "EstablishmentSpecification", "Entering specifications of establishment");
    //display order for screens
    private final Integer order;
    // key for screens
    private final String screenKey;
    private final String screenDescription;

    //Methods to Find Enum Constants
    WizardScreenEnum findScreenByOrderId(Integer orderIndex)
    {
        for(WizardScreenEnum wizardScreenEnum : values())
        {
            if(wizardScreenEnum.getOrder().equals(orderIndex))
            {
                return wizardScreenEnum;
            }
        }

        return null;
    }

    WizardScreenEnum findScreenByKey(String key)
    {
        for(WizardScreenEnum wizardScreenEnum : values())
        {
            if(wizardScreenEnum.getScreenKey().equals(key))
            {
                return wizardScreenEnum;
            }
        }

        return null;
    }
}
