package com.nhnacademy.certificate.service.impl;

import com.nhnacademy.certificate.dto.CertificateDTO;
import com.nhnacademy.certificate.dto.FamilyCertificateDTO;
import com.nhnacademy.certificate.entity.CertificateIssue;
import com.nhnacademy.certificate.repository.CertificateIssueRepository;
import com.nhnacademy.certificate.service.CertificateIssueService;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CertificateServiceImpl implements CertificateIssueService {
    private final CertificateIssueRepository repository;

    public CertificateServiceImpl(CertificateIssueRepository repository) {
        this.repository = repository;
    }

    @Override
    public CertificateDTO findCertificate(String type) {
        return new CertificateDTO(repository.findByCertificateTypeCode(type));
    }
}
