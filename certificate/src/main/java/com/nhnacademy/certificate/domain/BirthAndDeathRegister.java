package com.nhnacademy.certificate.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class BirthAndDeathRegister {
    @NotNull
    @Min(1)
    Integer residentSeralNo;

    @Size(min =2 ,max = 2)
    @NotNull
    String reportType;

    @NotNull
    LocalDateTime brithDate;

    @Min(1)
    @NotNull
    String qualificationCode;

    @Email
    String email;

    String phone;





}
