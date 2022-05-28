package com.nhnacademy.certificate.entity;

import com.nhnacademy.certificate.entity.pk.FamilyRelationShipPk;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Entity
@Table(name = "family_relationship")
public class FamilyRelationship {

    @EmbeddedId
    private FamilyRelationShipPk familyRelationShipPk;

    @MapsId("baseResidentNo")
    @ManyToOne
    @JoinColumn(name ="resident_serial_number")
    public Resident resident;

    @Column(name = "family_relationship_code")
    private String familyRelationCode;

}
