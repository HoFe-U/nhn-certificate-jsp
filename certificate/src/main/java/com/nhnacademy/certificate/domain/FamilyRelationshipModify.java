package com.nhnacademy.certificate.domain;


import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamilyRelationshipModify {
    @NotNull
    private String relationship;
}
