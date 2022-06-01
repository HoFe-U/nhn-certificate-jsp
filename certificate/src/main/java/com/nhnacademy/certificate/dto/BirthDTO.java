package com.nhnacademy.certificate.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.Getter;

@Getter
public class BirthDTO {
    private String name;

    private String registrationNo;

    private String code;

    private LocalDate reportDate;

    private String brithCode;

    private String email="";

    private String phone="";

    private String reportName;

    private String reportRegistrationNo;

    private String birthDate;

    private String registrationAddress;

    private String birthPlace;

    private String gender;

    public BirthDTO(BirthInfoDTO dto,ResidentDTO residentDTO) {
        this.name = dto.getBirthCode();
        this.registrationNo = dto.getRegistrationNo();
        this.code = dto.getCode();
        this.reportDate = dto.getReportDate();
        this.brithCode = dto.getBirthCode();
        this.email = dto.getEmail();
        this.phone = dto.getPhone();
        this.birthDate = dto.getBirthDate().format(DateTimeFormatter.ofPattern(
            "yyyy년MM월dd일 HH시mm분"));
        this.registrationAddress = dto.getRegistrationAddress();
        this.birthPlace = dto.getBirthPlace();
        this.reportName = residentDTO.getName();
        this.reportRegistrationNo = residentDTO.getRegistrationNo().split("-")[0]+"*******";
        this.gender = dto.getGender();
    }
}
