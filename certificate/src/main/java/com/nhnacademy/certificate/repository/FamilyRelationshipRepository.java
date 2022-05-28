package com.nhnacademy.certificate.repository;

import com.nhnacademy.certificate.entity.FamilyRelationship;
import com.nhnacademy.certificate.entity.pk.FamilyRelationShipPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship, FamilyRelationShipPk> {
}
