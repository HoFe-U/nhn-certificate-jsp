package com.nhnacademy.certificate.service;

import com.nhnacademy.certificate.domain.ModifyResidentRequest;
import com.nhnacademy.certificate.domain.ResidentRegister;
import com.nhnacademy.certificate.entity.Resident;

public interface ResidentService {
    Resident registerResident(ResidentRegister resident);

    Resident modifyResident(ModifyResidentRequest resident, Integer serialNo);

    Resident getResident(Integer serialNo);
}
