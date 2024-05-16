package com.wizard.demo.dto;

import lombok.Data;

@Data
public class OwnerDTO extends BaseDTO{
    private String ownerName;
    private String ownerPhone;
    private String ownerEmail;
}
