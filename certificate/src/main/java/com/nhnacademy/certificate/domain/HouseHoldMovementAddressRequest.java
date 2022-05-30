package com.nhnacademy.certificate.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class HouseHoldMovementAddressRequest {

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate reportDate;

    String movementAddress;
}
