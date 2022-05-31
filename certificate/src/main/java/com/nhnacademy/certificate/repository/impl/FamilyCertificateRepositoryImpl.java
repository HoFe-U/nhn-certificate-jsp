package com.nhnacademy.certificate.repository.impl;

import com.nhnacademy.certificate.dto.FamilyCertificateDTO;
import com.nhnacademy.certificate.dto.QFamilyCertificateDTO;
import com.nhnacademy.certificate.entity.CertificateIssue;

import com.nhnacademy.certificate.entity.QCertificateIssue;
import com.nhnacademy.certificate.entity.QHousehold;
import com.nhnacademy.certificate.repository.FamilyCertificateRepositoryCustom;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class FamilyCertificateRepositoryImpl extends QuerydslRepositorySupport implements FamilyCertificateRepositoryCustom{
    public FamilyCertificateRepositoryImpl() {
        super(CertificateIssue.class);
    }

    @Override
    public List<FamilyCertificateDTO> findFamilyCertificate(Integer residentNo) {
        QCertificateIssue certificateIssue = QCertificateIssue.certificateIssue;
        QHousehold household = QHousehold.household;
        String value = "가족관계증명서";

        return from(certificateIssue)
            .innerJoin(certificateIssue,certificateIssue)
            .where(certificateIssue.certificateTypeCode.eq(value)
                .and(household.resident.residentNo.eq(residentNo)))
            .select(new QFamilyCertificateDTO(certificateIssue.certificationNo,
                certificateIssue.certificateIssueDate,
                household.currentHouseMovementAddress))
            .fetch();
    }
}
