package com.nhnacademy.certificate.repository;

import com.nhnacademy.certificate.dto.FamilyCertificateDTO;
import com.nhnacademy.certificate.dto.FamilyRelationshipDto;
import com.nhnacademy.certificate.entity.FamilyRelationship;
import com.nhnacademy.certificate.entity.pk.FamilyRelationShipPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FamilyRelationshipRepository
    extends JpaRepository<FamilyRelationship, FamilyRelationShipPk> {


    List<FamilyRelationship> findAllByFamilyRelationShipPk_BaseResidentNo(Integer residentNo);

}

