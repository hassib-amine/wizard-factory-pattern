package com.wizard.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WizardScreenRequestTypeEnum {

    /*
    Define whether  request thrown by the frontend is a post request or a put request
    */
    CREATE("CREATE"),
    UPDATE("UPDATE");

    private String requestType;

    WizardScreenRequestTypeEnum getScreenRequestTypeByKey(String key)
    {
        for (WizardScreenRequestTypeEnum wizardScreenRequestTypeEnum: values())
        {
            if(wizardScreenRequestTypeEnum.getRequestType().equals(key))
            {
                return wizardScreenRequestTypeEnum;
            }
        }

        return null;
    }

}
