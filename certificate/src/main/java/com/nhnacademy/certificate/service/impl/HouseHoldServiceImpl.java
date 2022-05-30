package com.nhnacademy.certificate.service.impl;

import com.nhnacademy.certificate.domain.HouseholdRegister;
import com.nhnacademy.certificate.entity.Household;
import com.nhnacademy.certificate.entity.HouseholdMovementAddress;
import com.nhnacademy.certificate.entity.Resident;
import com.nhnacademy.certificate.exception.NoHouseholdException;
import com.nhnacademy.certificate.exception.NoResidentException;
import com.nhnacademy.certificate.repository.HouseholdMovementAddressRepository;
import com.nhnacademy.certificate.repository.HouseholdRepository;
import com.nhnacademy.certificate.repository.ResidentRepository;
import com.nhnacademy.certificate.service.HouseholdService;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HouseHoldServiceImpl implements HouseholdService {
    private final HouseholdRepository householdRepository;
    private final HouseholdMovementAddressRepository movementAddressRepository;
    private final ResidentRepository residentRepository;

    public HouseHoldServiceImpl(
        HouseholdRepository householdRepository,
        HouseholdMovementAddressRepository movementAddressRepository,
        ResidentRepository residentRepository) {

        this.householdRepository = householdRepository;
        this.movementAddressRepository = movementAddressRepository;
        this.residentRepository = residentRepository;
    }

    @Transactional
    @Override
    public Household createHousehold(HouseholdRegister householdRegister) {
        //TODO : household 예외 처리해야하나 ??
        Resident resident =
            residentRepository.checkResidentExist(householdRegister.getHouseHoldName(),
                    householdRegister.getHouseHoldRegistrationNo())
                .orElseThrow(NoResidentException::new);

        Household household = new Household();
        household.setResident(resident);
        household.setCompositionCode(householdRegister.getCompositionCode());
        household.setCompositionDate(householdRegister.getCompositionDate());
        household.setCurrentHouseMovementAddress(householdRegister.getMovementAddress());

        return householdRepository.save(household);
    }

    @Modifying
    @Transactional
    @Override
    public void deleteHousehold(Integer serialNo) {
        Household household =
            householdRepository.findById(serialNo).orElseThrow(NoHouseholdException::new);

        householdRepository.delete(household);
    }

    @Override
    public Household getHousehold(Integer serialNo) {
        return householdRepository.findById(serialNo).orElseThrow(NoHouseholdException::new);
    }
}
