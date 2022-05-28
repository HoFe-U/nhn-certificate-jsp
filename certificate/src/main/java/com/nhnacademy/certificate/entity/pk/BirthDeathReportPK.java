package com.nhnacademy.certificate.entity.pk;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BirthDeathReportPK implements Serializable {

    private Integer residentNo;

    @Column(name = "birth_death_type_code")
    private String birthDeathCode;

    @Column(name = "report_resident_serial_number")
    private Integer reportResidentNo;
}