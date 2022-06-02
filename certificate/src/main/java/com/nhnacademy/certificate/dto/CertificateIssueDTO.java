package com.nhnacademy.certificate.dto;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class CertificateIssueDTO {
    private Long certificationNo;

    private String certificateTypeCode;

    private LocalDateTime certificateIssueDate;


    public CertificateIssueDTO(CertificateListDTO dto) {
        this.certificationNo = dto.getCertificateNo();
        this.certificateTypeCode = dto.getCode();
        this.certificateIssueDate = dto.getDate();
    }

}
