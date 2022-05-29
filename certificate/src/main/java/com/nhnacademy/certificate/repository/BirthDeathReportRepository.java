package com.nhnacademy.certificate.repository;

import com.nhnacademy.certificate.entity.BirthDeathReport;
import com.nhnacademy.certificate.entity.pk.BirthDeathReportPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirthDeathReportRepository extends JpaRepository<BirthDeathReport, BirthDeathReportPK> {

}


