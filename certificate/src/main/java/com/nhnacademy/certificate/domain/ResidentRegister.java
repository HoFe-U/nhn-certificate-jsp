package com.nhnacademy.certificate.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class ResidentRegister {
    @NotNull
    String name;
    @NotNull
    String registrationNo;
    @NotNull
    String gender;
    @NotNull
    LocalDateTime birthDate;
    @NotNull
    String registrationAddress;

}
