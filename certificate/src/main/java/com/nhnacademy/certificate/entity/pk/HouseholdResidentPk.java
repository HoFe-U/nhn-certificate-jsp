package com.nhnacademy.certificate.entity.pk;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class HouseholdResidentPk implements Serializable {

    private Integer householdSerialNo;

    private Integer residentSerialNo;
}
