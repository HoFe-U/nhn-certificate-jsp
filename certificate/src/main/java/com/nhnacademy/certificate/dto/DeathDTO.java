package com.nhnacademy.certificate.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.Getter;

@Getter
public class DeathDTO {
    private String name;

    private String registrationNo;

    private String code;

    private LocalDate reportDate;

    private String deathCode;

    private String email = "";

    private String phone = "";

    private String deathDate;

    private String placeAddress;

    private String placeCode;

    private String reportResidentName;

    private String reportResidentRegistrationNo;

    public DeathDTO(DeathInfoDTO dto, ResidentDTO residentDTO) {
        this.name = dto.getName();
        this.registrationNo = dto.getRegistrationNo().split("-")[0] + "*******";
        this.code = dto.getDeathCode();
        this.reportDate = dto.getReportDate();
        this.deathCode = dto.getDeathCode();
        this.email = dto.getEmail();
        this.phone = dto.getPhone();
        this.reportResidentName = residentDTO.getName();
        this.reportResidentRegistrationNo =
            residentDTO.getRegistrationNo().split("-")[0] + "*******";
        this.deathDate = dto.getDeathDate().format(DateTimeFormatter.ofPattern(
            "yyyy년MM월dd일 HH시mm분"));
        this.placeAddress = dto.getPlaceAddress();
        this.placeCode = dto.getPlaceCode();
    }
}
