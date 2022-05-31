package com.nhnacademy.certificate.dto;

import com.nhnacademy.certificate.entity.Resident;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ResidentDTO {
    private Integer residentNo;
    private String name;
    private String genderCode;

    public ResidentDTO(Resident resident) {
        this.residentNo = resident.getResidentNo();
        this.name = resident.getName();
        this.genderCode = resident.getGenderCode();
    }
}
