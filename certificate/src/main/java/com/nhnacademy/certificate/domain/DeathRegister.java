package com.nhnacademy.certificate.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeathRegister {

    @NotNull
    String residentName;

    String residentRegistrationNo;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate deathReportDate;

    @NotNull
    String qualificationCode;

    String email;

    String phone;

    String deathPlaceCode;

    String deathPlaceAddress;

    @JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    LocalDateTime deathDate;
}
