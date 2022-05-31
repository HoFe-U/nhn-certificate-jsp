package com.nhnacademy.certificate.domain;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseholdCompositionDelete {
    @NotNull
    private String name;
    @NotNull
    private String registrationNo;
}
