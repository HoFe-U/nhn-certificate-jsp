package com.nhnacademy.certificate.entity;

import com.nhnacademy.certificate.entity.pk.HouseHoldMovementAddressPk;
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
@Table(name = "household_movement_address")
public class HouseholdMovementAddress {
    @EmbeddedId
    private HouseHoldMovementAddressPk holdMovementAddress;

    @ManyToOne
    @MapsId("houseHoldNo")
    @JoinColumn(name = "householdSerialNumber")
    public Household household;

    private String houseMovementAddress;

    @Column(name = "last_address_yn")
    private String lastAddress;
}
