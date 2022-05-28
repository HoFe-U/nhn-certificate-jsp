package com.nhnacademy.certificate.repository;

import com.nhnacademy.certificate.entity.HouseholdCompositionResident;
import com.nhnacademy.certificate.entity.pk.HouseholdCompositionResidentPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdCompositionResidentRepository
    extends JpaRepository<HouseholdCompositionResident, HouseholdCompositionResidentPK> {

}
