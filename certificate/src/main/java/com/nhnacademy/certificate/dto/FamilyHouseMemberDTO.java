package com.nhnacademy.certificate.dto;

import com.nhnacademy.certificate.entity.Resident;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


@Getter
public class FamilyHouseMemberDTO {
    private String name;
    private String registrationNo;
    private String code;
    private String compositionCode;
    private LocalDate reportDate;

    public FamilyHouseMemberDTO(String name, String registrationNo, String code,
                                String compositionCode, LocalDate reportDate) {
        this.name = name;
        this.registrationNo = registrationNo;
        this.code = code;
        this.compositionCode = compositionCode;
        this.reportDate = reportDate;
    }

    public FamilyHouseMemberDTO(FamilyHouseMoveDTO familyHouseMoveDTO, Resident resident) {
        this.name = resident.getName();
        this.registrationNo = resident.getRegistrationNo();
        this.code = familyHouseMoveDTO.getCompositionCode();
        this.compositionCode = familyHouseMoveDTO.getCode();
        this.reportDate = familyHouseMoveDTO.getReportDate();
    }
}
