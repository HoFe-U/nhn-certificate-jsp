package com.nhnacademy.certificate.service;

import com.nhnacademy.certificate.domain.BirthDeathModify;
import com.nhnacademy.certificate.domain.DeathRegister;
import com.nhnacademy.certificate.entity.BirthDeathReport;

import javax.validation.Valid;

public interface DeathService {
    BirthDeathReport createDeath(Integer serialNo, @Valid DeathRegister birthDeathReportRegister);

    void modifyDeath(Integer serialNo, BirthDeathModify birthModify, Integer targetSerialNo);

    void deleteDeath(Integer serialNo, Integer targetSerialNo);
}
