package com.nhnacademy.certificate.repository;

import com.nhnacademy.certificate.entity.Household;
import com.nhnacademy.certificate.entity.Resident;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdRepository extends JpaRepository<Household, Integer> {
    Optional<Household> findByResidentEquals(Resident resident);

    boolean existsByResident_ResidentNo(Integer residentNo);

    void deleteByResident_ResidentNo(Integer residentNo);

}
