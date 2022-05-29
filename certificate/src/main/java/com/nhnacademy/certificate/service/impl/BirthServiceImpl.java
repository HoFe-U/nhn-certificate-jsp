package com.nhnacademy.certificate.service.impl;

import com.nhnacademy.certificate.domain.BirthAndDeathRegister;
import com.nhnacademy.certificate.domain.BirthModify;
import com.nhnacademy.certificate.entity.BirthDeathReport;
import com.nhnacademy.certificate.entity.Resident;
import com.nhnacademy.certificate.entity.pk.BirthDeathReportPK;
import com.nhnacademy.certificate.exception.AlreadyExistsException;
import com.nhnacademy.certificate.exception.NoReportException;
import com.nhnacademy.certificate.exception.NoResidentException;
import com.nhnacademy.certificate.repository.BirthDeathReportRepository;
import com.nhnacademy.certificate.repository.ResidentRepository;
import com.nhnacademy.certificate.service.BirthService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BirthServiceImpl implements BirthService {
    private final BirthDeathReportRepository birthDeathReportRepository;
    private final ResidentRepository residentRepository;

    public BirthServiceImpl(BirthDeathReportRepository repository, ResidentRepository residentRepository) {
        this.birthDeathReportRepository = repository;
        this.residentRepository = residentRepository;
    }

    //TODO : 중복 구문 메소드 분리해야됨
    @Transactional
    @Override
    public BirthDeathReport createBirth(Integer serialNo, BirthAndDeathRegister register) {
        BirthDeathReportPK pk = new BirthDeathReportPK();
        pk.setBirthDeathCode(register.getReportType());
        pk.setResidentNo(register.getResidentSeralNo());
        pk.setReportResidentNo(serialNo);
        Resident resident = residentRepository.findById(serialNo).orElseThrow(NoResidentException::new);
        if (birthDeathReportRepository.findById(pk).isPresent()) {
            throw new AlreadyExistsException();
        }

        BirthDeathReport birthDeathReport = new BirthDeathReport();
        birthDeathReport.setBirthDeathReportPK(pk);
        birthDeathReport.setBirthDeathReportDate(register.getBrithDate());
        birthDeathReport.setBirthQualificationCode(register.getQualificationCode());
        birthDeathReport.setResident(resident);
        birthDeathReport.setEmailAddress(register.getEmail());
        birthDeathReport.setPhoneNumber(register.getPhone());

        return birthDeathReportRepository.save(birthDeathReport);
    }

    @Transactional
    @Override
    public BirthDeathReport modifyBirth(Integer serialNo, BirthModify birthModify, Integer targetSerialNo) {
        BirthDeathReportPK pk = new BirthDeathReportPK();
        residentRepository.findById(serialNo).orElseThrow(NoResidentException::new);
        Resident resident = residentRepository.findById(birthModify.getResidentSerialNo()).orElseThrow(NoResidentException::new);

        pk.setBirthDeathCode("출생");
        pk.setResidentNo(targetSerialNo);
        pk.setReportResidentNo(serialNo);

        BirthDeathReport birthDeathReport = birthDeathReportRepository.findById(pk).orElseThrow(NoReportException::new);
        pk.setResidentNo(birthModify.getResidentSerialNo());

        birthDeathReport.setPhoneNumber(birthModify.getPhoneNo());
        birthDeathReport.setEmailAddress(birthModify.getEmail());
        birthDeathReport.setBirthQualificationCode(birthModify.getQualificationCode());
        birthDeathReport.setResident(resident);

       return birthDeathReportRepository.save(birthDeathReport);
    }

    @Transactional
    @Override
    public void deleteBirth(Integer serialNo, Integer targetSerialNo) {
        BirthDeathReportPK pk = new BirthDeathReportPK();
        pk.setReportResidentNo(serialNo);
        pk.setBirthDeathCode("출생");
        pk.setResidentNo(targetSerialNo);

        BirthDeathReport birthDeathReport = birthDeathReportRepository.findById(pk).orElseThrow(NoReportException::new);
        birthDeathReportRepository.delete(birthDeathReport);
    }

}
