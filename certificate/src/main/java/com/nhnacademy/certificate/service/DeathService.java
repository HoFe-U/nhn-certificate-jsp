package com.nhnacademy.certificate.service;

import com.nhnacademy.certificate.domain.BirthAndDeathRegister;
import com.nhnacademy.certificate.domain.BirthModify;
import com.nhnacademy.certificate.entity.BirthDeathReport;

import javax.validation.Valid;

public interface DeathService {
    BirthDeathReport createDeath(Integer serialNo, @Valid BirthAndDeathRegister birthDeathReportRegister);

    BirthDeathReport modifyDeath(Integer serialNo, BirthModify birthModify, Integer targetSerialNo);

    void deleteDeath(Integer serialNo, Integer targetSerialNo);
}
