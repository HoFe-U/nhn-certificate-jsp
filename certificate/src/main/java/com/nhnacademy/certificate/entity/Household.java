package com.nhnacademy.certificate.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "household")
public class Household {

    @Id
    private Integer householdSerialNumber;

    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    public Resident resident;

    @Column(name = "household_composition_date")
    private LocalDateTime compositionDate;

    @Column(name = "household_composition_reason_code")
    private String compositionCode;

    private String currentHouseMovementAddress;
}
