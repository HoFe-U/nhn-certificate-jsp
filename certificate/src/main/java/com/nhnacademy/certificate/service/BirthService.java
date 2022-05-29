package com.nhnacademy.certificate.service;

import com.nhnacademy.certificate.domain.BirthAndDeathRegister;
import com.nhnacademy.certificate.domain.BirthModify;
import com.nhnacademy.certificate.entity.BirthDeathReport;

import javax.validation.Valid;

public interface BirthService {
    BirthDeathReport createBirth(Integer serialNo, @Valid BirthAndDeathRegister birthDeathReportRegister);

    BirthDeathReport modifyBirth(Integer serialNo, BirthModify birthModify, Integer targetSerialNo);

    void deleteBirth(Integer serialNo, Integer targetSerialNo);
}
