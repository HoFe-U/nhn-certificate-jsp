package com.nhnacademy.certificate.service;

import com.nhnacademy.certificate.dto.CertificateDTO;
import com.nhnacademy.certificate.dto.FamilyCertificateDTO;
import java.util.List;

public interface CertificateIssueService {
    CertificateDTO findCertificate(String type);
}
