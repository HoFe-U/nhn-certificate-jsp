package com.nhnacademy.certificate.repository;

import com.nhnacademy.certificate.entity.Household;
import com.nhnacademy.certificate.entity.HouseholdMovementAddress;
import com.nhnacademy.certificate.entity.pk.HouseHoldMovementAddressPk;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HouseholdMovementAddressRepository
        extends JpaRepository<HouseholdMovementAddress, HouseHoldMovementAddressPk> {

    @Query("select m from HouseholdMovementAddress as m where m.holdMovementAddress.houseMovementReportDate > ?1")
    List<HouseholdMovementAddress> findByLastAddressEquals(LocalDate date);

    List<HouseholdMovementAddress> findByHousehold(Household household);
}
