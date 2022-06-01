package com.nhnacademy.certificate.dto;

import com.nhnacademy.certificate.entity.FamilyRelationship;
import com.nhnacademy.certificate.entity.Resident;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FamilyRelationshipDTO {
    private String familyRelationCode;
    private String name;
    private LocalDateTime birthDate;
    private String registrationNo;
    private String genderCode;


    public FamilyRelationshipDTO(Resident resident , FamilyRelationship relationship) {
        this.familyRelationCode = relationship.getFamilyRelationCode();
        this.name = resident.getName();
        this.birthDate = resident.getBirthDate();
        this.registrationNo = resident.getRegistrationNo().split("-")[0] +"********";
        this.genderCode = resident.getGenderCode();
    }

    public FamilyRelationshipDTO(Resident resident , String familyRelationCode) {
        this.familyRelationCode = familyRelationCode;
        this.name = resident.getName();
        this.birthDate = resident.getBirthDate();
        this.registrationNo = resident.getRegistrationNo().split("-")[0] + "*******";
        this.genderCode = resident.getGenderCode();
    }
}
