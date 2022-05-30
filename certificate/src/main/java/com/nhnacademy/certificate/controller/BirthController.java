package com.nhnacademy.certificate.controller;

import com.nhnacademy.certificate.domain.BirthRegister;
import com.nhnacademy.certificate.domain.BirthDeathModify;
import com.nhnacademy.certificate.entity.BirthDeathReport;
import com.nhnacademy.certificate.exception.NoResidentException;
import com.nhnacademy.certificate.service.BirthService;
import com.nhnacademy.certificate.service.ResidentService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.Objects;


@RestController
@RequestMapping("/residents/{serialNumber}/birth")
public class BirthController {
    private final BirthService service;
    private final ResidentService residentService;

    public BirthController(BirthService service, ResidentService residentService) {
        this.service = service;
        this.residentService = residentService;
    }

    @ModelAttribute(value = "birth", binding = false)
    public Integer checkSerialNo(@PathVariable("serialNumber") Integer serialNo) {
        if (Objects.isNull(residentService.getResident(serialNo))) {
            throw new NoResidentException();
        }
        return serialNo;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public BirthDeathReport addBirthReport(@ModelAttribute("birth") Integer serialNo,
                                              @Valid @RequestBody BirthRegister register,
                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }

        return service.createBirth(serialNo, register);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{targetSerialNumber}")
    public void fixBirthReport(@ModelAttribute("birth") Integer serialNo,
                               @PathVariable("targetSerialNumber") Integer targetSerialNo,
                               @Valid @RequestBody BirthDeathModify birthModify,
                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        service.modifyBirth(serialNo, birthModify, targetSerialNo);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{targetSerialNumber}")
    public void deleteBirthReport(@ModelAttribute("birth") Integer serialNo,
                                  @PathVariable("targetSerialNumber") Integer targetSerialNo){
        service.deleteBirth(serialNo,targetSerialNo);
    }
}
