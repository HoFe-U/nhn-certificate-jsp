package com.nhnacademy.certificate.dto;

import com.nhnacademy.certificate.entity.CertificateIssue;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class CertificateDTO {
    private  String certificateTypeCode;
    private LocalDateTime certificateIssueDate;

    public CertificateDTO(CertificateIssue certificateIssue) {
        this.certificateTypeCode = certificateIssue.getCertificateTypeCode();
        this.certificateIssueDate = certificateIssue.getCertificateIssueDate();
    }

    public CertificateDTO(String code, LocalDateTime time) {
        this.certificateTypeCode = code;
        this.certificateIssueDate = time;
    }
}
