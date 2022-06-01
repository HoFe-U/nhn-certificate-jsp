package com.nhnacademy.certificate.service.impl;

import com.nhnacademy.certificate.domain.HouseholdRegister;
import com.nhnacademy.certificate.dto.HouseMovementDTO;
import com.nhnacademy.certificate.dto.HouseholdDTO;
import com.nhnacademy.certificate.entity.Household;
import com.nhnacademy.certificate.entity.HouseholdMovementAddress;
import com.nhnacademy.certificate.entity.Resident;
import com.nhnacademy.certificate.entity.pk.HouseHoldMovementAddressPk;
import com.nhnacademy.certificate.exception.NoHouseholdException;
import com.nhnacademy.certificate.exception.NoResidentException;
import com.nhnacademy.certificate.repository.HouseholdCompositionResidentRepository;
import com.nhnacademy.certificate.repository.HouseholdMovementAddressRepository;
import com.nhnacademy.certificate.repository.HouseholdRepository;
import com.nhnacademy.certificate.repository.ResidentRepository;
import com.nhnacademy.certificate.service.HouseholdService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HouseHoldServiceImpl implements HouseholdService {
    private final HouseholdRepository householdRepository;
    private final ResidentRepository residentRepository;
    private final HouseholdCompositionResidentRepository compositionResidentRepository;
    private final HouseholdMovementAddressRepository movementAddressRepository;


    public HouseHoldServiceImpl(
        HouseholdRepository householdRepository,
        ResidentRepository residentRepository,
        HouseholdCompositionResidentRepository householdCompositionResidentRepository,
        HouseholdMovementAddressRepository movementAddressRepository) {

        this.householdRepository = householdRepository;
        this.residentRepository = residentRepository;
        this.compositionResidentRepository = householdCompositionResidentRepository;
        this.movementAddressRepository = movementAddressRepository;
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

    @Override
    public HouseholdDTO findHouseholdGetDTO(Integer serialNo) {
        Resident resident =
            residentRepository.findById(serialNo).orElseThrow(NoResidentException::new);
        Household household =
            compositionResidentRepository.findHouseholdCompositionResident(resident)
                .orElseThrow(NoResidentException::new);
        List<HouseholdMovementAddress> list =
            movementAddressRepository.findByHousehold(household);
        List<HouseMovementDTO> houseMovementDTOS = new ArrayList<>();

        for (HouseholdMovementAddress address : list) {
            houseMovementDTOS.add(new HouseMovementDTO(address));
        }


        return new HouseholdDTO(household,houseMovementDTOS);
    }

}
