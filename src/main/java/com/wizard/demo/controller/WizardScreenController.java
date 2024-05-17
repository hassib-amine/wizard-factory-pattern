package com.wizard.demo.controller;

import com.wizard.demo.dto.WizardRequestDTO;
import com.wizard.demo.dto.WizardScreenDTO;
import com.wizard.demo.enums.WizardScreenEnum;
import com.wizard.demo.service.IWizardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("wizard")
public class WizardScreenController {
    private final IWizardService wizardService;

    @Autowired
    public WizardScreenController(IWizardService wizardService) {
        this.wizardService = wizardService;
    }

    @GetMapping("/getWizard")
    public ResponseEntity<WizardScreenDTO> getWizard(@RequestParam Long id, @RequestParam WizardScreenEnum wizardScreenEnum)
    {
        return wizardService.getWizard(id,wizardScreenEnum);
    }

    @PostMapping(value = "/postWizard")
    public ResponseEntity<WizardScreenDTO> postWizard(@RequestBody WizardRequestDTO wizardRequestDTO)
    {
        return wizardService.postWizard(wizardRequestDTO);
    }


}
