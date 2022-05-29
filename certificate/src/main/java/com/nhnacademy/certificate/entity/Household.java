package com.nhnacademy.certificate.entity;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "household")
public class Household {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer householdSerialNumber;

    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    public Resident resident;

    @Column(name = "household_composition_date")
    @Temporal(TemporalType.DATE)
    private Date compositionDate;

    @Column(name = "household_composition_reason_code")
    private String compositionCode;

    @Column(name = "current_house_movement_address")
    private String currentHouseMovementAddress;
}
