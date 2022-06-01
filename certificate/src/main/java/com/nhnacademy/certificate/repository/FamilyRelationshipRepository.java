package com.nhnacademy.certificate.repository;

import com.nhnacademy.certificate.dto.FamilyHouseMoveDTO;
import com.nhnacademy.certificate.entity.FamilyRelationship;
import com.nhnacademy.certificate.entity.pk.FamilyRelationShipPk;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FamilyRelationshipRepository
    extends JpaRepository<FamilyRelationship, FamilyRelationShipPk> {


    List<FamilyRelationship> findAllByFamilyRelationShipPk_BaseResidentNo(Integer residentNo);

    @Query("select f.familyRelationShipPk.familyResidentNo as residentNo ,f.familyRelationCode as code, hcr.compositionCode as compositionCode,hcr.reportDate as reportDate from FamilyRelationship as f inner join HouseholdCompositionResident as hcr on hcr.resident.residentNo = f.familyRelationShipPk.familyResidentNo where f.familyRelationShipPk.baseResidentNo = ?1")
    List<FamilyHouseMoveDTO> findHouseMoveMembers(Integer residentNo);

}

