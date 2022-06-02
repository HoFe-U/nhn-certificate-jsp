package com.nhnacademy.certificate.repository;

import com.nhnacademy.certificate.dto.CertificateListDTO;
import com.nhnacademy.certificate.entity.CertificateIssue;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CertificateIssueRepository extends JpaRepository<CertificateIssue, Long> {

    CertificateIssue findByCertificateTypeCode(String code);

    List<CertificateIssue> findAllByResident_ResidentNoAndCertificateTypeCode(Integer residentNo,String code);

    @Query("select c.resident.residentNo as residentNo," +
        "c.certificateTypeCode as code," +
        "c.certificateIssueDate as date," +
        "c.certificationNo as certificateNo" +
        " from CertificateIssue as c where c.resident.residentNo=?1")

    Page<CertificateListDTO> findByCertificateList(Pageable pageable, Integer residentNo);

    void deleteByResident_ResidentNo(Integer residentNo);
}
