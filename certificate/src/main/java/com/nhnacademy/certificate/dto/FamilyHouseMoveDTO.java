package com.nhnacademy.certificate.dto;


import com.nhnacademy.certificate.entity.Resident;
import java.time.LocalDate;

public interface FamilyHouseMoveDTO {
    Integer getResidentNo();

    String getCode();

    String getCompositionCode();

    LocalDate getReportDate();

}
