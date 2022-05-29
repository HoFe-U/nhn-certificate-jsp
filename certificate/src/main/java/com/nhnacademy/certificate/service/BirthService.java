package com.nhnacademy.certificate.service;

import com.nhnacademy.certificate.domain.BirthRegister;
import com.nhnacademy.certificate.domain.BirthDeathModify;
import com.nhnacademy.certificate.entity.BirthDeathReport;

import javax.validation.Valid;

public interface BirthService {
    BirthDeathReport createBirth(Integer serialNo, @Valid BirthRegister birthDeathReportRegister);

    BirthDeathReport modifyBirth(Integer serialNo, BirthDeathModify birthModify, Integer targetSerialNo);

    void deleteBirth(Integer serialNo, Integer targetSerialNo);
}
