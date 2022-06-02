package com.nhnacademy.certificate.dto;

import java.time.LocalDateTime;
import lombok.Getter;


public interface CertificateListDTO {
    Integer getResidentNo();

    String getCode();

    LocalDateTime getDate();

    Long getCertificateNo();
}
