package com.nhnacademy.certificate.dto;

import com.nhnacademy.certificate.entity.HouseholdMovementAddress;
import java.time.LocalDate;
import lombok.Data;

@Data
public class HouseMovementDTO {
    private LocalDate houseReportDate;
    private String movementAddress;
    private String lastAddress;


    public HouseMovementDTO(HouseholdMovementAddress address) {
        this.houseReportDate = address.getHoldMovementAddress().getHouseMovementReportDate();
        this.movementAddress = address.getHouseMovementAddress();
        this.lastAddress = address.getLastAddress();
    }
}

