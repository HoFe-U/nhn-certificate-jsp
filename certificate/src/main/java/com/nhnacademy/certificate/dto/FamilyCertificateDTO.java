package com.nhnacademy.certificate.dto;

import com.querydsl.core.annotations.QueryProjection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@NoArgsConstructor
public class FamilyCertificateDTO {
    private Long certificateNo;
    private LocalDateTime localDate;
    private String address;
    private String typeCode;

    public FamilyCertificateDTO(Long certificateNo, LocalDateTime localDate, String address, String typeCode) {
        this.certificateNo = certificateNo;
        this.localDate = localDate;
        this.address = address;
        this.typeCode = typeCode;
    }


}
