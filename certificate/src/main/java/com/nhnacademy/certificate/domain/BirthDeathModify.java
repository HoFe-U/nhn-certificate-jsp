package com.nhnacademy.certificate.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BirthDeathModify {

    @NotNull
    String registrationNo;

    @NotNull
    String residentName;

    @NotNull
    String qualificationCode;

    String email;

    String phoneNo;
}
