package com.nhnacademy.certificate.entity.pk;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Getter
@Setter
public class FamilyRelationShipPk implements Serializable {
    @Column(name = "family_resident_serial_number")
    private Integer familyResidentNo;

    private Integer baseResidentNo;
}
