package com.nhnacademy.certificate.entity;

import com.nhnacademy.certificate.entity.pk.HouseholdCompositionResidentPK;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "household_composition_resident")
public class HouseholdCompositionResident {

    @EmbeddedId
    private HouseholdCompositionResidentPK householdCompositionResidentPK;

    @MapsId("householdNo")
    @ManyToOne
    @JoinColumn(name = "household_serial_number")
    Household household;

    @MapsId("residentNo")
    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    Resident resident;

}
