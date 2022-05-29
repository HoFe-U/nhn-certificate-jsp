package com.nhnacademy.certificate.service;

import com.nhnacademy.certificate.domain.FamilyRelationshipModify;
import com.nhnacademy.certificate.domain.FamilyRelationshipRegister;
import com.nhnacademy.certificate.entity.FamilyRelationship;

public interface FamilyRelationshipService {

    FamilyRelationship createRelationship(Integer serialNo, FamilyRelationshipRegister familyRelationshipRegister);

    FamilyRelationship modifyRelationship(Integer serialNo, Integer fmSerialNo, FamilyRelationshipModify familyRelationshipModify);

    void deleteRelationship(Integer serialNo, Integer fmSerialNo);
}
