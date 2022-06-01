package com.nhnacademy.certificate.dto;

import lombok.Getter;

@Getter
public class MotherFatherInfoDTO {
    private String name;
    private String registrationNo;

    public MotherFatherInfoDTO(MotherFatherDTO motherOrFather) {
        this.name = motherOrFather.getName();
        this.registrationNo = motherOrFather.getRegistrationNo();
    }
}
