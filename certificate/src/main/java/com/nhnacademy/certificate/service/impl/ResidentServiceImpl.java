package com.nhnacademy.certificate.service.impl;

import com.nhnacademy.certificate.domain.ModifyResidentRequest;
import com.nhnacademy.certificate.domain.ResidentRegister;
import com.nhnacademy.certificate.dto.ResidentDTO;
import com.nhnacademy.certificate.entity.Resident;
import com.nhnacademy.certificate.exception.NoResidentException;
import com.nhnacademy.certificate.repository.ResidentRepository;
import com.nhnacademy.certificate.service.ResidentService;
import org.springframework.data.domain.Pageable;
import java.util.Objects;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Modifying;
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
        if (Objects.isNull(addRequest)) {
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

    @Modifying(clearAutomatically = true)
    @Transactional
    @Override
    public void modifyResident(ModifyResidentRequest modify, Integer serialNo) {
        Resident resident =
            residentRepository.findById(serialNo).orElseThrow(NoResidentException::new);
        resident.setName(modify.getName());
        resident.setGenderCode(modify.getGender());
        resident.setRegistrationNo(modify.getRegistrationNo());
        resident.setDeathPlaceAddress(modify.getRegistrationAddress());
        residentRepository.flush();
    }

    @Override
    public Resident getResident(Integer serialNo) {
        return residentRepository.findById(serialNo).orElseThrow(NoResidentException::new);
    }

    @Override
    public Page<ResidentDTO> getResidents(Pageable pageable) {
        return residentRepository.findAll(pageable).map(ResidentDTO::new);
    }

}
