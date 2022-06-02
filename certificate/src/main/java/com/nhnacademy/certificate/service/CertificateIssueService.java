package com.nhnacademy.certificate.service;

import com.nhnacademy.certificate.dto.CertificateDTO;
import com.nhnacademy.certificate.dto.CertificateIssueDTO;
import com.nhnacademy.certificate.dto.FamilyCertificateDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CertificateIssueService {
    CertificateDTO findCertificate(String type);

    Page<CertificateIssueDTO> findCertificateList(Pageable pageable, Integer residentNo);

    void creatCertificateIssue(Integer residentNo, String typeCode);

    CertificateDTO findCertificateList(Integer residentNo, String code);
}
