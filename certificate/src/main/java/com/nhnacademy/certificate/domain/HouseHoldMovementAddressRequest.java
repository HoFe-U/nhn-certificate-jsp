package com.nhnacademy.certificate.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class HouseHoldMovementAddressRequest {

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDateTime reportDate;

    String movementAddress;
}
