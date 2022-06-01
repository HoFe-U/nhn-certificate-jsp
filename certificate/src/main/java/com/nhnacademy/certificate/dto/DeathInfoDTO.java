package com.nhnacademy.certificate.dto;


import java.time.LocalDate;
import java.time.LocalDateTime;

public interface DeathInfoDTO {
    String getName();

    String getRegistrationNo();

    String getCode();

    LocalDate getReportDate();

    String getDeathCode();

    String getEmail();

    String getPhone();

    Integer getReportNo();

    LocalDateTime getDeathDate();

    String getPlaceAddress();

    String getPlaceCode();
}
