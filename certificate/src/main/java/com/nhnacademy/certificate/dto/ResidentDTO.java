package com.nhnacademy.certificate.dto;

import com.nhnacademy.certificate.entity.Resident;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ResidentDTO {
    private Integer residentNo;
    private String name;
    private String genderCode;
    private String registrationNo;
    private boolean checkDeath = false;
    private boolean checkBirth = false;

    public ResidentDTO(Resident resident) {
        this.residentNo = resident.getResidentNo();
        this.name = resident.getName();
        this.genderCode = resident.getGenderCode();
        this.registrationNo = resident.getRegistrationNo();
    }
}
