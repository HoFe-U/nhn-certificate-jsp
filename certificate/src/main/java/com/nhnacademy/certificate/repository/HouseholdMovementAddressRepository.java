package com.nhnacademy.certificate.repository;

import com.nhnacademy.certificate.entity.HouseholdMovementAddress;
import com.nhnacademy.certificate.entity.pk.HouseHoldMovementAddressPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdMovementAddressRepository
    extends JpaRepository<HouseholdMovementAddress, HouseHoldMovementAddressPk> {

}
