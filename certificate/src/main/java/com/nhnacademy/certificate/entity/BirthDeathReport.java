package com.nhnacademy.certificate.entity;

import com.nhnacademy.certificate.entity.pk.BirthDeathReportPK;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Table(name = "birth_death_report_resident")
@Entity
public class BirthDeathReport {
    @EmbeddedId
    private BirthDeathReportPK birthDeathReportPK;

    @MapsId("residentNo")
    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    private Resident resident;
    @Column(name = "birth_death_report_date")
    private LocalDateTime birthDeathReportDate;

    @Column(name = "birth_report_qualifications_code")
    private String birthQualificationCode;

    @Column(name = "death_report_qualifications_code")
    private String deathQualificationCode;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "phone_number")
    private String phoneNumber;
}
