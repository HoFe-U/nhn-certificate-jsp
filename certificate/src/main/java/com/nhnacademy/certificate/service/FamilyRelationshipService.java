package com.nhnacademy.certificate.service;

import com.nhnacademy.certificate.domain.FamilyRelationshipModify;
import com.nhnacademy.certificate.domain.FamilyRelationshipRegister;
import com.nhnacademy.certificate.dto.FamilyRelationshipDto;
import com.nhnacademy.certificate.entity.FamilyRelationship;

import java.util.List;

public interface FamilyRelationshipService{

    FamilyRelationship createRelationship(Integer serialNo, FamilyRelationshipRegister familyRelationshipRegister);

    void modifyRelationship(Integer serialNo, Integer fmSerialNo, FamilyRelationshipModify familyRelationshipModify);

    void deleteRelationship(Integer serialNo, Integer fmSerialNo);

    List<FamilyRelationshipDto> getFamilyCertificateInfo(Integer residentNo);
}
