package com.nhnacademy.certificate.service.impl;

import com.nhnacademy.certificate.dto.FamilyCertificateDTO;
import com.nhnacademy.certificate.exception.NoResidentException;
import com.nhnacademy.certificate.repository.CertificateIssueRepository;
import com.nhnacademy.certificate.service.CertificateIssueService;
import com.nhnacademy.certificate.service.FamilyRelationshipService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CertificateServiceImpl implements CertificateIssueService {
    private final CertificateIssueRepository certificateIssueRepository;

    public CertificateServiceImpl(
        CertificateIssueRepository certificateIssueRepository) {
        this.certificateIssueRepository = certificateIssueRepository;
    }

    @Override
    public List<FamilyCertificateDTO> findFamilyCertificateUpper(Integer residentNo) {
        List<FamilyCertificateDTO> familyCertificate =
            certificateIssueRepository.findFamilyCertificate(residentNo);
        if (familyCertificate.isEmpty())
        {
            throw new NoResidentException();
        }
        return familyCertificate;
    }

}
