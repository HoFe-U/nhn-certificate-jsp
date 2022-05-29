package com.nhnacademy.certificate.service.impl;

import com.nhnacademy.certificate.domain.BirthAndDeathRegister;
import com.nhnacademy.certificate.domain.BirthModify;
import com.nhnacademy.certificate.entity.BirthDeathReport;
import com.nhnacademy.certificate.repository.BirthDeathReportRepository;
import com.nhnacademy.certificate.repository.ResidentRepository;
import com.nhnacademy.certificate.service.DeathService;

public class DeathServiceImpl implements DeathService {
    private final BirthDeathReportRepository deathReportRepository;
    private final ResidentRepository residentRepository;

    public DeathServiceImpl(BirthDeathReportRepository repository, BirthDeathReportRepository deathReportRepository, ResidentRepository residentRepository) {
        this.deathReportRepository = deathReportRepository;

        this.residentRepository = residentRepository;
    }

    @Override
    public BirthDeathReport createDeath(Integer serialNo, BirthAndDeathRegister birthDeathReportRegister) {
        return null;
    }

    @Override
    public BirthDeathReport modifyDeath(Integer serialNo, BirthModify birthModify, Integer targetSerialNo) {
        return null;
    }

    @Override
    public void deleteDeath(Integer serialNo, Integer targetSerialNo) {

    }
}
