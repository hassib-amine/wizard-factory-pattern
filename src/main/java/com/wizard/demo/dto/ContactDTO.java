package com.wizard.demo.dto;

import lombok.Data;

@Data
public class ContactDTO extends BaseDTO{

    private String phoneNumber;
    private String email;
}
