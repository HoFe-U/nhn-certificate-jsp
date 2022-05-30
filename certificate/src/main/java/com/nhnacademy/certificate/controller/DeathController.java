package com.nhnacademy.certificate.controller;

import com.nhnacademy.certificate.domain.BirthDeathModify;
import com.nhnacademy.certificate.domain.DeathRegister;
import com.nhnacademy.certificate.entity.BirthDeathReport;
import com.nhnacademy.certificate.exception.NoResidentException;
import com.nhnacademy.certificate.service.DeathService;
import com.nhnacademy.certificate.service.ResidentService;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/residents/{serialNumber}/death")
public class DeathController {
    private final DeathService service;
    private final ResidentService residentService;

    public DeathController(DeathService service, ResidentService residentService) {
        this.service = service;
        this.residentService = residentService;
    }

    @ModelAttribute(value = "death", binding = false)
    public Integer checkSerialNo(@PathVariable("serialNumber") Integer serialNo) {
        if (Objects.isNull(residentService.getResident(serialNo))) {
            throw new NoResidentException();
        }
        return serialNo;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public BirthDeathReport deathRegistReport(@ModelAttribute("death") Integer serialNo,
                                              @Valid @RequestBody DeathRegister deathRegister,
                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }

        return service.createDeath(serialNo, deathRegister);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{targetSerialNumber}")
    public void fixDeathReport(@ModelAttribute("death") Integer serialNo,
                                           @PathVariable("targetSerialNumber")
                                               Integer targetSerialNo,
                                           @Valid @RequestBody BirthDeathModify birthModify,
                                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        service.modifyDeath(serialNo, birthModify, targetSerialNo);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{targetSerialNumber}")
    public void deleteDeathReport(@ModelAttribute("death") Integer serialNo,
                                  @PathVariable("targetSerialNumber") Integer targetSerialNo) {
        service.deleteDeath(serialNo, targetSerialNo);
    }
}
