package com.nhnacademy.certificate.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class HouseholdRegister {
    @NotNull
    String houseHoldName;

    @NotNull
    String houseHoldRegistrationNo;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate compositionDate;

    @NotNull
    String compositionCode;

    @NotNull
    String movementAddress;


}
