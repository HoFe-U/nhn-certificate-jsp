package com.nhnacademy.certificate.dto;

import com.querydsl.core.annotations.QueryProjection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
public class FamilyCertificateDTO {
    private Long certificateNo;
    private LocalDateTime localDate;
    private String address;

    @QueryProjection
    public FamilyCertificateDTO(
        Long certificateNo, LocalDateTime localDate, String address) {
        this.certificateNo = certificateNo;
        this.localDate = localDate;
        this.address = address;
    }
}
