package com.nhnacademy.certificate.domain;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HouseholdCompositionRequest {
    @NotNull
    private String name;
    @NotNull
    private String registrationNo;
    @NotNull

    private LocalDate reportDate;
    @NotNull
    private String code;
    @NotNull
    private String compositionCode;
}
