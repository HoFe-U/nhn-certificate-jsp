package com.nhnacademy.certificate.service;

import com.nhnacademy.certificate.domain.HouseholdRegister;
import com.nhnacademy.certificate.entity.Household;

public interface HouseholdService {
    Household createHousehold(HouseholdRegister householdRegister);

    void deleteHousehold(Integer serialNo);

    Household getHousehold(Integer serialNo);
}
