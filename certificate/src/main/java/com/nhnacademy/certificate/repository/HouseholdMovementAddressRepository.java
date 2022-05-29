package com.nhnacademy.certificate.repository;

import com.nhnacademy.certificate.entity.HouseholdMovementAddress;
import com.nhnacademy.certificate.entity.pk.HouseHoldMovementAddressPk;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HouseholdMovementAddressRepository
    extends JpaRepository<HouseholdMovementAddress, HouseHoldMovementAddressPk> {
    HouseholdMovementAddress findByLastAddress(String lastAddress);


}
