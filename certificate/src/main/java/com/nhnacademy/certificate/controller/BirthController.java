package com.nhnacademy.certificate.controller;

import com.nhnacademy.certificate.domain.BirthAndDeathRegister;
import com.nhnacademy.certificate.domain.BirthModify;
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
    public BirthDeathReport birthRegistReport(@ModelAttribute("birth") Integer serialNo,
                                              @Valid @RequestBody BirthAndDeathRegister birthDeathReportRegister,
                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }

        return service.createBirth(serialNo, birthDeathReportRegister);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{targetSerialNumber}")
    public BirthDeathReport fixBirthReport(@ModelAttribute("birth") Integer serialNo,
                               @PathVariable("targetSerialNumber") Integer targetSerialNo,
                               @Valid @RequestBody BirthModify birthModify,
                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        return service.modifyBirth(serialNo, birthModify, targetSerialNo);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{targetSerialNumber}")
    public void deleteBirthReport(@ModelAttribute("birth") Integer serialNo,
                                  @PathVariable("targetSerialNumber") Integer targetSerialNo){
        service.deleteBirth(serialNo,targetSerialNo);
    }
}
