package com.nhnacademy.certificate.domain;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class HouseholdRegister {
    @Min(2)
    @NotNull
    String houseHoldName;

    @NotNull
    @Min(14)
    String houseHoldRegistrationNo;

    @NotNull
    @Temporal(TemporalType.DATE)
    Date compositionDate;

    @NotNull
    String compositionCode;

    @NotNull
    String movementAddress;


}
