package com.nhnacademy.certificate.domain;

import java.time.LocalDateTime;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeathRegister {
    @NotNull
    @Min(2)
    String residentName;

    String residentRegistrationNo;

    @NotNull
    LocalDateTime deathReportDate;

    @Min(1)
    @NotNull
    String qualificationCode;

    @Email
    String email;

    String phone;

    String deathPlaceCode;

    String deathPlaceAddress;

    LocalDateTime deathDate;
}
