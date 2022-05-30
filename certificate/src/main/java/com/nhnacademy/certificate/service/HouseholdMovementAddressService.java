package com.nhnacademy.certificate.service;

import com.nhnacademy.certificate.domain.HouseHoldMovementAddressRequest;
import com.nhnacademy.certificate.domain.ModifyMovementAddress;
import com.nhnacademy.certificate.entity.Household;
import com.nhnacademy.certificate.entity.HouseholdMovementAddress;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface HouseholdMovementAddressService {
    HouseholdMovementAddress createAddress(Household serialNo, HouseHoldMovementAddressRequest movementAddressRequest);

    void modifyHouseholdMovementAddress(Household household, @DateTimeFormat(pattern = "yyyyMMdd")  LocalDate dateTime, ModifyMovementAddress modifyMovementAddress);

    void deleteMovementAddress(Household household, LocalDate dateTime);
}

