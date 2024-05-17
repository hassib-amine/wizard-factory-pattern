package com.wizard.demo.service.screens;

import com.wizard.demo.dto.BaseDTO;

import com.wizard.demo.dto.EtablishmentDTO;
import com.wizard.demo.dto.LocationDTO;
import com.wizard.demo.dto.WizardScreenDTO;
import com.wizard.demo.enums.WizardScreenEnum;
import com.wizard.demo.service.IWizardScreenService;
import org.springframework.stereotype.Service;

@Service
public class LocationScreenService implements IWizardScreenService {
    @Override
    public <T extends BaseDTO> T getWizard(Long id) {

        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        LocationDTO locationDTO = createLocationDTO(id);
        wizardScreenDTO.setLocationDTO(locationDTO);
        return (T) wizardScreenDTO;
    }

    @Override
    public <T extends BaseDTO> T createModelWizard(WizardScreenDTO createWizardScreenDTO) {

        LocationDTO locationDTO = createWizardScreenDTO.getLocationDTO();
        EtablishmentDTO etablishmentDTO = createWizardScreenDTO.getEtablishmentDTO();

        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        LocationDTO createdEtablishmentLocationDTO = saveLocationDTO(locationDTO);
        wizardScreenDTO.setLocationDTO(createdEtablishmentLocationDTO);
        wizardScreenDTO.setEtablishmentDTO(etablishmentDTO);

        return (T) wizardScreenDTO;
    }


    @Override
    public <T extends BaseDTO> T updateModelWizard(WizardScreenDTO updateddWizardScreenDTO) {
        LocationDTO locationDTO = updateddWizardScreenDTO.getLocationDTO();
        EtablishmentDTO etablishmentDTO = updateddWizardScreenDTO.getEtablishmentDTO();

        //save database or send another service

        WizardScreenDTO wizardScreenDTO = new WizardScreenDTO();
        LocationDTO updateLocationDTO = updateLocationDTO(locationDTO);

        wizardScreenDTO.setLocationDTO(updateLocationDTO);
        wizardScreenDTO.setEtablishmentDTO(etablishmentDTO);


        return (T) wizardScreenDTO;
    }

    @Override
    public WizardScreenEnum getScreenName() {
        return WizardScreenEnum.ESTABLISHMENT_LOCATION_SCREEN;
    }

    private LocationDTO createLocationDTO(Long id) {
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(id);
        locationDTO.setAddress("Address 1 ");
        locationDTO.setCountry("Country 1 ");
        locationDTO.setCity("City 1 ");
        locationDTO.setState("State 1");
        locationDTO.setPostalCode("20400 ");
        return locationDTO;
    }
    private LocationDTO saveLocationDTO(LocationDTO locationDTO) {
        Long id = 1l;
        LocationDTO createdDto = new LocationDTO();
        createdDto.setId(id);
        createdDto.setAddress(locationDTO.getAddress());
        createdDto.setCity(locationDTO.getCity());
        createdDto.setCountry(locationDTO.getCountry());
        createdDto.setState(locationDTO.getState());
        createdDto.setPostalCode(locationDTO.getPostalCode());

        return createdDto;

    }

    private LocationDTO updateLocationDTO(LocationDTO locationDTO) {
        //update database
        return locationDTO;
    }
}
