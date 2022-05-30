package com.nhnacademy.certificate.controller;

import com.nhnacademy.certificate.domain.ModifyResidentRequest;
import com.nhnacademy.certificate.domain.ResidentRegister;
import com.nhnacademy.certificate.entity.Resident;
import com.nhnacademy.certificate.exception.ModifyResidentException;
import com.nhnacademy.certificate.service.ResidentService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/residents")
public class ResidentController {
    private final ResidentService service;

    public ResidentController(ResidentService service) {
        this.service = service;
    }

    //TODO: 반환값 오류날수도 있을듯
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Resident addResident(@Valid @RequestBody ResidentRegister addRequest,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException();
        }
        return service.registerResident(addRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{serialNumber}")
    public void fixResidentInfo(@PathVariable Integer serialNumber,
                                    @Valid ModifyResidentRequest residentRequest,
                                    BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw new ModifyResidentException();
        }
        service.modifyResident(residentRequest, serialNumber);
    }
}
