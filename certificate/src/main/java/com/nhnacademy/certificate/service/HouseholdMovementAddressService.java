package com.nhnacademy.certificate.service;

import com.nhnacademy.certificate.domain.HouseHoldMovementAddressRequest;
import com.nhnacademy.certificate.domain.ModifyMovementAddress;
import com.nhnacademy.certificate.entity.Household;
import com.nhnacademy.certificate.entity.HouseholdMovementAddress;
import java.time.LocalDateTime;

public interface HouseholdMovementAddressService {
    HouseholdMovementAddress createAddress(Household serialNo, HouseHoldMovementAddressRequest movementAddressRequest);

    HouseholdMovementAddress modifyHouseholdMovementAddress(Household household, LocalDateTime dateTime, ModifyMovementAddress modifyMovementAddress);

    void deleteMovementAddress(Household household, LocalDateTime dateTime);
}

