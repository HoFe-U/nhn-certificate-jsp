package com.nhnacademy.certificate.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface BirthInfoDTO {
    Integer getName();

    String getRegistrationNo();

    String getCode();

    LocalDate getReportDate();

    String getBirthCode();

    String getEmail();

    String getPhone();

    Integer getReportNo();

    LocalDateTime getBirthDate();

    String getRegistrationAddress();

    String getBirthPlace();

    String getGender();

}
