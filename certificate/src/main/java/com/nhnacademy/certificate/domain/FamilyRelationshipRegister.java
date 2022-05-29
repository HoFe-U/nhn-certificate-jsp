package com.nhnacademy.certificate.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Data
@Builder
public class FamilyRelationshipRegister {

    @NotNull
    Integer familySerialNo;
    @Size(min = 1,max = 6)
    @NotNull
    String relationship;


}
