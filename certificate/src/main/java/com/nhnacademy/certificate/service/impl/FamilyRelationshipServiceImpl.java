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
    public FamilyRelationship createRelationship(Integer serialNo,
                                                 FamilyRelationshipRegister familyRelationshipRegister) {
        Resident resident =
            residentRepository.findById(serialNo).orElseThrow(NoResidentException::new);
        Resident fmResident =
            residentRepository.findById(familyRelationshipRegister.getFamilySerialNo())
                .orElseThrow(NoResidentException::new);

        FamilyRelationship familyRelationship = new FamilyRelationship();
        FamilyRelationShipPk pk = new FamilyRelationShipPk();


        pk.setFamilyResidentNo(fmResident.getResidentNo());
        pk.setBaseResidentNo(resident.getResidentNo());

        familyRelationship.setFamilyRelationShipPk(pk);
        familyRelationship.setResident(resident);
        familyRelationship.setFamilyRelationCode(familyRelationshipRegister.getRelationship());

        return repository.saveAndFlush(familyRelationship);
    }

    @Transactional
    @Override
    public void modifyRelationship(Integer serialNo, Integer fmSerialNo, FamilyRelationshipModify familyRelationshipModify) {
        FamilyRelationShipPk pk = new FamilyRelationShipPk();
        pk.setBaseResidentNo(serialNo);
        pk.setFamilyResidentNo(fmSerialNo);

        FamilyRelationship familyRelationship = repository.findById(pk).orElseThrow(NoRelationShip::new);
        familyRelationship.setFamilyRelationCode(familyRelationshipModify.getRelationship());

        repository.flush();
    }

    @Transactional
    @Override
    public void deleteRelationship(Integer serialNo, Integer fmSerialNo) {
        FamilyRelationShipPk pk = new FamilyRelationShipPk();
        pk.setBaseResidentNo(serialNo);
        pk.setFamilyResidentNo(fmSerialNo);
        if (repository.findById(pk).isEmpty()) {
            throw new NoRelationShip();
        }
        repository.deleteById(pk);
    }
}
