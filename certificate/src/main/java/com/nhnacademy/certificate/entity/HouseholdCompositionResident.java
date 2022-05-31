package com.nhnacademy.certificate.entity;

import com.nhnacademy.certificate.entity.pk.HouseholdCompositionResidentPK;
import java.time.LocalDate;
import javax.persistence.Column;
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

    @Column(name = "report_date")
    private LocalDate reportDate;

    @Column(name = "household_relationship_code")
    private String relationCode;

    @Column(name = "household_composition_change_reason_code")
    private String compositionCode;


}
