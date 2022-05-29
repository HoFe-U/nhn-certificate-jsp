package com.nhnacademy.certificate.domain;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ModifyMovementAddress {
    @NotNull
    private String address;

}
