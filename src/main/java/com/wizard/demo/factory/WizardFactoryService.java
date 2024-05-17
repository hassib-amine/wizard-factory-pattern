package com.wizard.demo.factory;

import com.wizard.demo.enums.WizardScreenEnum;
import com.wizard.demo.service.IWizardScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
this factory class actually does:
 is it will create the class that manages the screen associated with this enum value and return it to us,
according to the wizardSceenEnum parameter we sent
*/
@Service
public class WizardFactoryService {
    private Map<WizardScreenEnum, IWizardScreenService> wizardScreens;

    @Autowired
    public WizardFactoryService(Set<IWizardScreenService> IWizardScreenServiceSet){
        createScreenWizard(IWizardScreenServiceSet);
    }

    public IWizardScreenService getScreenWizard(WizardScreenEnum wizardScreenEnum){
        return wizardScreens.get(wizardScreenEnum);
    }

    private void  createScreenWizard(Set<IWizardScreenService> IwizardScreenServiceSet){
        wizardScreens = new HashMap<>();
        IwizardScreenServiceSet.forEach(projectWizardService ->
                wizardScreens.put
                (
                    projectWizardService.getScreenName(),projectWizardService
                )
        );
    }

}
