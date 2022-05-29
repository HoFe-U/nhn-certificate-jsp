package com.nhnacademy.certificate.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
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
    String birthPlaceCode;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime birthDate;
    @NotNull
    String registrationAddress;

}
