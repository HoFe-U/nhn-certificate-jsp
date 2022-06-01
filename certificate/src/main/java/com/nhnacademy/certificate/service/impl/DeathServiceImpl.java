package com.nhnacademy.certificate.service.impl;

import com.nhnacademy.certificate.domain.BirthDeathModify;
import com.nhnacademy.certificate.domain.DeathRegister;
import com.nhnacademy.certificate.dto.DeathDTO;
import com.nhnacademy.certificate.dto.DeathInfoDTO;
import com.nhnacademy.certificate.dto.ResidentDTO;
import com.nhnacademy.certificate.entity.BirthDeathReport;
import com.nhnacademy.certificate.entity.Resident;
import com.nhnacademy.certificate.entity.pk.BirthDeathReportPK;
import com.nhnacademy.certificate.exception.AlreadyExistsException;
import com.nhnacademy.certificate.exception.NoReportException;
import com.nhnacademy.certificate.exception.NoResidentException;
import com.nhnacademy.certificate.repository.BirthDeathReportRepository;
import com.nhnacademy.certificate.repository.ResidentRepository;
import com.nhnacademy.certificate.service.DeathService;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeathServiceImpl implements DeathService {
    private final BirthDeathReportRepository deathReportRepository;
    private final ResidentRepository residentRepository;

    public DeathServiceImpl(BirthDeathReportRepository repository, BirthDeathReportRepository deathReportRepository, ResidentRepository residentRepository) {
        this.deathReportRepository = deathReportRepository;
        this.residentRepository = residentRepository;
    }

    @Transactional
    @Override
    public BirthDeathReport createDeath(Integer reportSerialNo, DeathRegister register) {
        residentRepository.findById(reportSerialNo).orElseThrow(NoResidentException::new);
        Resident resident = residentRepository.checkResidentExist(register.getResidentName(),
            register.getResidentRegistrationNo()).orElseThrow(NoResidentException::new);

        // resident 가 존재하는지 확인

        BirthDeathReport birthDeathReport = new BirthDeathReport();
        BirthDeathReportPK birthDeathReportPK = new BirthDeathReportPK();
        birthDeathReportPK.setBirthDeathCode("사망");
        birthDeathReportPK.setReportResidentNo(reportSerialNo);
        birthDeathReportPK.setResidentNo(resident.getResidentNo());

        if (deathReportRepository.existsById(birthDeathReportPK)) {
            throw new AlreadyExistsException();
        }
        //이미 사망신고를 했는지 확인

        resident.setDeathDate(register.getDeathDate());
        resident.setDeathPlaceCode(register.getDeathPlaceCode());
        resident.setDeathPlaceAddress(register.getDeathPlaceAddress());
        //주민에 대한 사망정보 추가

        birthDeathReport.setBirthDeathReportPK(birthDeathReportPK);
        birthDeathReport.setBirthDeathReportDate(register.getDeathReportDate());
        birthDeathReport.setDeathQualificationCode(register.getQualificationCode());
        birthDeathReport.setEmailAddress(register.getEmail());
        birthDeathReport.setPhoneNumber(register.getPhone());
        birthDeathReport.setResident(resident);

        residentRepository.save(resident);

        return deathReportRepository.save(birthDeathReport);
    }

    @Modifying
    @Transactional
    @Override
    public void modifyDeath(Integer serialNo, BirthDeathModify birthModify,
                                        Integer targetSerialNo) {
        residentRepository.findById(serialNo).orElseThrow(NoResidentException::new);
        residentRepository.findById(targetSerialNo).orElseThrow(NoResidentException::new);

        BirthDeathReportPK birthDeathReportPK = new BirthDeathReportPK();
        birthDeathReportPK.setBirthDeathCode("사망");
        birthDeathReportPK.setReportResidentNo(targetSerialNo);
        birthDeathReportPK.setResidentNo(serialNo);

        BirthDeathReport birthDeathReport =
            deathReportRepository.findById(birthDeathReportPK).orElseThrow(NoReportException::new);


        birthDeathReport.setBirthDeathReportPK(birthDeathReportPK);

         deathReportRepository.flush();
    }

    @Transactional
    @Override
    public void deleteDeath(Integer serialNo, Integer targetSerialNo) {
        BirthDeathReportPK pk = new BirthDeathReportPK();
        pk.setReportResidentNo(targetSerialNo);
        pk.setBirthDeathCode("사망");
        pk.setResidentNo(serialNo);

        BirthDeathReport birthDeathReport =
            deathReportRepository.findById(pk).orElseThrow(NoReportException::new);

        deathReportRepository.delete(birthDeathReport);
    }

    @Override
    public DeathDTO findDeathReport(Integer serialNo, String typeCode) {
        DeathInfoDTO deathInfo = deathReportRepository.findDeathInfo(typeCode, serialNo);
        Resident resident = residentRepository.findById(deathInfo.getReportNo())
            .orElseThrow(NoResidentException::new);


        return new DeathDTO(deathInfo,new ResidentDTO(resident));
    }
}
