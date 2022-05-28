package com.nhnacademy.certificate.service;

import com.nhnacademy.certificate.entity.Resident;

public interface ResidentService {
    Resident registerResident(Resident resident);

    boolean modifyResident(Resident resident, Integer serialNo);
}
