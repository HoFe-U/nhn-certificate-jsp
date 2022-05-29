package com.nhnacademy.certificate.service.impl;

import com.nhnacademy.certificate.domain.ModifyResidentRequest;
import com.nhnacademy.certificate.domain.ResidentRegister;
import com.nhnacademy.certificate.entity.Resident;
import com.nhnacademy.certificate.exception.NoResidentException;
import com.nhnacademy.certificate.repository.ResidentRepository;
import com.nhnacademy.certificate.service.ResidentService;
import java.util.Objects;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResidentServiceImpl implements ResidentService {
    private final ResidentRepository residentRepository;

    public ResidentServiceImpl(
        ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    @Transactional
    @Override
    public Resident registerResident(ResidentRegister addRequest) {
        if(Objects.isNull(addRequest)){
            throw new NoResidentException();
        }
        Resident resident = new Resident();
        resident.setName(addRequest.getName());
        resident.setRegistrationNo(addRequest.getRegistrationNo());
        resident.setGenderCode(addRequest.getGender());
        resident.setBirthDate(addRequest.getBirthDate());
        resident.setRegistrationAddress(addRequest.getRegistrationAddress());
        resident.setBirthPlaceCode(addRequest.getBirthPlaceCode());
        return residentRepository.save(resident);
    }

    @Transactional
    @Override
    public Resident modifyResident(ModifyResidentRequest modifyResident, Integer serialNo) {
        Resident resident = residentRepository.findById(serialNo).orElseThrow(NoResidentException::new);
        checkExchangeResident(modifyResident, resident);

        return resident;
    }

    @Override
    public Resident getResident(Integer serialNo) {
        return residentRepository.findById(serialNo).orElseThrow(NoResidentException::new);
    }

    //TODO 1: 리팩토링가능할듯(if 문)
    private void checkExchangeResident(ModifyResidentRequest modifyResident, Resident resident) {
        if(!modifyResident.getName().isEmpty()){
            resident.setName(modifyResident.getName());
        } else if (!modifyResident.getRegistrationNo().isEmpty()) {
            resident.setRegistrationNo(modifyResident.getRegistrationNo());
        } else if(!modifyResident.getGender().isEmpty()){
            resident.setGenderCode(modifyResident.getGender());
        } else if (!modifyResident.getRegistrationAddress().isEmpty()) {
            resident.setRegistrationAddress(modifyResident.getRegistrationAddress());
        }
    }
}
