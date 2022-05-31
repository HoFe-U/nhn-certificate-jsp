package com.nhnacademy.certificate.service;

import com.nhnacademy.certificate.dto.FamilyCertificateDTO;
import java.util.List;

public interface CertificateIssueService {
    List<FamilyCertificateDTO> findFamilyCertificateUpper(Integer residentNo);
}
