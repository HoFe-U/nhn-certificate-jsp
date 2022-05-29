package com.nhnacademy.certificate.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BirthModify {

    @NotNull
    Integer residentSerialNo;
    @NotNull
    String qualificationCode;

    String email;

    String phoneNo;
}
