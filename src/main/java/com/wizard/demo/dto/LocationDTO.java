package com.wizard.demo.dto;

import lombok.Data;

@Data
public class LocationDTO extends BaseDTO{

    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}
