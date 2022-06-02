package com.nhnacademy.certificate.service.impl;

import com.nhnacademy.certificate.dto.CertificateDTO;
import com.nhnacademy.certificate.dto.CertificateIssueDTO;
import com.nhnacademy.certificate.entity.CertificateIssue;
import com.nhnacademy.certificate.exception.NoResidentException;
import com.nhnacademy.certificate.repository.CertificateIssueRepository;
import com.nhnacademy.certificate.repository.ResidentRepository;
import com.nhnacademy.certificate.service.CertificateIssueService;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CertificateIssueServiceImpl implements CertificateIssueService {
    private final CertificateIssueRepository repository;
    private final ResidentRepository residentRepository;


    public CertificateIssueServiceImpl(CertificateIssueRepository repository,
                                       ResidentRepository residentRepository) {
        this.repository = repository;
        this.residentRepository = residentRepository;
    }

    @Override
    public CertificateDTO findCertificate(String type) {
        return new CertificateDTO(repository.findByCertificateTypeCode(type));
    }

    @Override
    public Page<CertificateIssueDTO> findCertificateList(Pageable pageable,Integer residentNo) {
        return repository.findByCertificateList(pageable, residentNo).map(CertificateIssueDTO::new);
    }

    @Transactional
    @Override
    public void creatCertificateIssue(Integer residentNo, String typeCode) {
        CertificateIssue certificateIssue = new CertificateIssue();
        Random random  =new Random(System.currentTimeMillis());

        certificateIssue.setCertificationNo(random.nextLong()+1000000000000L);
        certificateIssue.setCertificateIssueDate(LocalDateTime.now());
        certificateIssue.setCertificateTypeCode(typeCode);
        certificateIssue.setResident(residentRepository.findById(residentNo)
            .orElseThrow(NoResidentException::new));

        repository.saveAndFlush(certificateIssue);
    }

    @Override
    public CertificateDTO findCertificateList(Integer residentNo, String code) {
        List<CertificateIssue> list =
            repository.findAllByResident_ResidentNoAndCertificateTypeCode(residentNo, code);
        if(list.isEmpty()){
            return new CertificateDTO(code, LocalDateTime.now());
        }
        return new CertificateDTO(list.get(0));
    }
}
