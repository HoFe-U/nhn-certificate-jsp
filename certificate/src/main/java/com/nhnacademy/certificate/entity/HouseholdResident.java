package com.nhnacademy.certificate.entity;

import com.nhnacademy.certificate.entity.pk.HouseholdResidentPk;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "household_composition_resident")
public class HouseholdResident {
    @EmbeddedId
    private HouseholdResidentPk householdResidentPk;

    @MapsId("householdSerialNo")
    @ManyToOne
    @JoinColumn(name = "household_serial_number")
    private Household household;

    @MapsId("residentSerialNo")
    @ManyToOne
    @JoinColumn(name ="resident_serial_number" )
    private Resident resident;
}
