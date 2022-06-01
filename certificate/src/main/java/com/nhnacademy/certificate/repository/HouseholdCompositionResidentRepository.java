package com.nhnacademy.certificate.repository;

import com.nhnacademy.certificate.entity.Household;
import com.nhnacademy.certificate.entity.HouseholdCompositionResident;
import com.nhnacademy.certificate.entity.Resident;
import com.nhnacademy.certificate.entity.pk.HouseholdCompositionResidentPK;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HouseholdCompositionResidentRepository
    extends JpaRepository<HouseholdCompositionResident, HouseholdCompositionResidentPK> {

    @Query("select h.household from HouseholdCompositionResident as h where h.resident = ?1")
    Optional<Household> findHouseholdCompositionResident(Resident resident);

    @Query("select hcr from FamilyRelationship as f inner join HouseholdCompositionResident as hcr on hcr.resident = f.resident where f.familyRelationShipPk.baseResidentNo = ?1")
    List<HouseholdCompositionResident> findHouseholdMembers(Integer residentNo);
}
