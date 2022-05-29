package com.nhnacademy.certificate.service.impl;

import com.nhnacademy.certificate.domain.FamilyRelationshipModify;
import com.nhnacademy.certificate.domain.FamilyRelationshipRegister;
import com.nhnacademy.certificate.entity.FamilyRelationship;
import com.nhnacademy.certificate.entity.Resident;
import com.nhnacademy.certificate.entity.pk.FamilyRelationShipPk;
import com.nhnacademy.certificate.exception.NoRelationShip;
import com.nhnacademy.certificate.exception.NoResidentException;
import com.nhnacademy.certificate.repository.FamilyRelationshipRepository;
import com.nhnacademy.certificate.repository.ResidentRepository;
import com.nhnacademy.certificate.service.FamilyRelationshipService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FamilyRelationshipServiceImpl implements FamilyRelationshipService {
    private final FamilyRelationshipRepository repository;
    private final ResidentRepository residentRepository;

    public FamilyRelationshipServiceImpl(FamilyRelationshipRepository repository, ResidentRepository resident, ResidentRepository residentRepository) {
        this.repository = repository;
        this.residentRepository = residentRepository;
    }

    @Transactional
    @Override
    public FamilyRelationship createRelationship(Integer serialNo, FamilyRelationshipRegister familyRelationshipRegister) {
        FamilyRelationship familyRelationship = new FamilyRelationship();
        FamilyRelationShipPk familyRelationShipPk = new FamilyRelationShipPk();
        Resident resident = residentRepository.findById(serialNo).orElseThrow(NoResidentException::new);

        familyRelationShipPk.setBaseResidentNo(resident.getResidentNo());
        familyRelationShipPk.setFamilyResidentNo(familyRelationshipRegister.getFamilySerialNo());

        familyRelationship.setFamilyRelationCode(familyRelationshipRegister.getRelationship());
        familyRelationship.setResident(resident);
        familyRelationship.setFamilyRelationShipPk(familyRelationShipPk);

        return repository.save(familyRelationship);
    }

    //TODO : repository 에 업로드를 안해도 바뀌냐
    @Transactional
    @Override
    public FamilyRelationship modifyRelationship(Integer serialNo, Integer fmSerialNo, FamilyRelationshipModify familyRelationshipModify) {
        FamilyRelationShipPk pk = new FamilyRelationShipPk();
        pk.setFamilyResidentNo(serialNo);
        pk.setFamilyResidentNo(fmSerialNo);

        FamilyRelationship familyRelationship = repository.findById(pk).orElseThrow(NoRelationShip::new);
        familyRelationship.setFamilyRelationCode(familyRelationshipModify.getRelationship());

        return familyRelationship;
    }

    @Transactional
    @Override
    public void deleteRelationship(Integer serialNo, Integer fmSerialNo) {
        FamilyRelationShipPk pk = new FamilyRelationShipPk();
        pk.setFamilyResidentNo(serialNo);
        pk.setFamilyResidentNo(fmSerialNo);
        if (repository.findById(pk).isEmpty()) {
            throw new NoRelationShip();
        }
        repository.deleteById(pk);
    }
}
