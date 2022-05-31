package com.nhnacademy.certificate.repository;

import com.nhnacademy.certificate.dto.FamilyCertificateDTO;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface FamilyCertificateRepositoryCustom {
    List<FamilyCertificateDTO> findFamilyCertificate(Integer residentNo);
}
