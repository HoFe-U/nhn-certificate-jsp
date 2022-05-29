package com.nhnacademy.certificate.domain;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
public class ModifyResidentRequest {
    @Min(2)
    String name;

    String registrationNo;
    @Size(min = 1, max = 1)

    String gender;

    @Size(min = 5, max = 100)
    String registrationAddress;
}
