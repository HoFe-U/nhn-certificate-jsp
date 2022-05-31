package com.nhnacademy.certificate.service.impl;

import com.nhnacademy.certificate.domain.HouseholdCompositionDelete;
import com.nhnacademy.certificate.domain.HouseholdCompositionRequest;
import com.nhnacademy.certificate.entity.Household;
import com.nhnacademy.certificate.entity.HouseholdCompositionResident;
import com.nhnacademy.certificate.entity.Resident;
import com.nhnacademy.certificate.entity.pk.HouseholdCompositionResidentPK;
import com.nhnacademy.certificate.exception.NoCompositionResidentException;
import com.nhnacademy.certificate.exception.NoResidentException;
import com.nhnacademy.certificate.repository.HouseholdCompositionResidentRepository;
import com.nhnacademy.certificate.repository.ResidentRepository;
import com.nhnacademy.certificate.service.HouseholdCompositionResidentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HouseHoldCompositionServiceImpl implements HouseholdCompositionResidentService {
    private final HouseholdCompositionResidentRepository compositionResidentRepository;
    private final ResidentRepository residentRepository ;
    public HouseHoldCompositionServiceImpl(
        HouseholdCompositionResidentRepository compositionResidentRepository,
        ResidentRepository residentRepository) {
        this.compositionResidentRepository = compositionResidentRepository;
        this.residentRepository = residentRepository;
    }

    @Override
    public HouseholdCompositionResident createCompositionResident(Household household,
                                                                  HouseholdCompositionRequest request) {
        HouseholdCompositionResident compositionResident = new HouseholdCompositionResident();
        Resident resident =
            residentRepository.checkResidentExist(request.getName(), request.getRegistrationNo())
                .orElseThrow(
                    NoResidentException::new);

        HouseholdCompositionResidentPK pk = new HouseholdCompositionResidentPK();
        pk.setHouseholdNo(household.getHouseholdSerialNumber());
        pk.setResidentNo(resident.getResidentNo());

        compositionResident.setCompositionCode(request.getCompositionCode());
        compositionResident.setReportDate(request.getReportDate());
        compositionResident.setHousehold(household);
        compositionResident.setResident(resident);
        compositionResident.setHouseholdCompositionResidentPK(pk);
        compositionResident.setRelationCode(request.getCode());
        return compositionResidentRepository.save(compositionResident);
    }

    @Transactional
    @Override
    public void deleteCompositionResident(Household household, HouseholdCompositionDelete delete) {
        Resident resident =
            residentRepository.checkResidentExist(delete.getName(), delete.getRegistrationNo())
                .orElseThrow(NoResidentException::new);

        HouseholdCompositionResidentPK pk = new HouseholdCompositionResidentPK();
        pk.setHouseholdNo(household.getHouseholdSerialNumber());
        pk.setResidentNo(resident.getResidentNo());

        HouseholdCompositionResident compositionResident =
            compositionResidentRepository.findById(pk)
                .orElseThrow(NoCompositionResidentException::new);

        compositionResidentRepository.delete(compositionResident);
    }
}
