package com.nhnacademy.certificate.service.impl;

import com.nhnacademy.certificate.entity.Resident;
import com.nhnacademy.certificate.exception.NoResidentException;
import com.nhnacademy.certificate.repository.ResidentRepository;
import com.nhnacademy.certificate.service.ResidentService;
import java.util.Objects;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("residentService")
public class ResidentServiceImpl implements ResidentService {
    private final ResidentRepository residentRepository;

    public ResidentServiceImpl(
        ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    @Transactional
    @Override
    public Resident registerResident(Resident resident) {
        if(Objects.isNull(resident)){
            throw new NoResidentException();
        }
        return residentRepository.save(resident);
    }

    @Transactional
    @Override
    public boolean modifyResident(Resident modifyResident, Integer serialNo) {
        residentRepository.findById(serialNo).orElseThrow(NoResidentException::new);
        return true;
    }
}
