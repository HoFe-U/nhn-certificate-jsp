package com.nhnacademy.certificate.entity.pk;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class BirthDeathReportPK implements Serializable {

    private Integer residentNo;

    @Column(name = "birth_death_type_code")
    private String birthDeathCode;

    @Column(name = "report_resident_serial_number")
    private Integer reportResidentNo;
}