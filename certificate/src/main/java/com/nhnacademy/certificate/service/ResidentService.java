package com.nhnacademy.certificate.service;

import com.nhnacademy.certificate.domain.ModifyResidentRequest;
import com.nhnacademy.certificate.domain.ResidentRegister;
import com.nhnacademy.certificate.dto.ResidentDTO;
import com.nhnacademy.certificate.entity.Resident;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface ResidentService {
    Resident registerResident(ResidentRegister resident);

    void modifyResident(ModifyResidentRequest resident, Integer serialNo);

    Resident getResident(Integer serialNo);

    Page<ResidentDTO> getResidents(Pageable pageable);

}
