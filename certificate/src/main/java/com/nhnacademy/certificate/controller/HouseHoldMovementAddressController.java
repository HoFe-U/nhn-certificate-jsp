package com.nhnacademy.certificate.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nhnacademy.certificate.domain.HouseHoldMovementAddressRequest;
import com.nhnacademy.certificate.domain.ModifyMovementAddress;
import com.nhnacademy.certificate.entity.Household;
import com.nhnacademy.certificate.entity.HouseholdMovementAddress;
import com.nhnacademy.certificate.exception.NoHouseholdException;
import com.nhnacademy.certificate.service.HouseholdMovementAddressService;
import com.nhnacademy.certificate.service.HouseholdService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.format.annotation.DateTimeFormat;
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
@RequestMapping("/household/{householdSerialNumber}/movement")
public class HouseHoldMovementAddressController {
    private final HouseholdMovementAddressService service;
    private final HouseholdService householdService;

    public HouseHoldMovementAddressController(
            HouseholdMovementAddressService service, HouseholdService householdService) {

        this.service = service;
        this.householdService = householdService;
    }

    @ModelAttribute(value = "householdNo", binding = false)
    public Household checkSerialNo(@PathVariable("householdSerialNumber") Integer serialNo) {
        Household household = householdService.getHousehold(serialNo);
        if (Objects.isNull(household)) {
            throw new NoHouseholdException();
        }
        return household;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HouseholdMovementAddress addMovementAddress(
            @ModelAttribute("householdNo") Household household,
            @Valid @RequestBody
                    HouseHoldMovementAddressRequest movementAddressRequest,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        return service.createAddress(household, movementAddressRequest);
    }

    @PutMapping("/{reportDate}")
    @ResponseStatus(HttpStatus.OK)
    public void fixMovementAddress(
            @ModelAttribute("householdNo") Household household,
            @PathVariable("reportDate") LocalDate dateTime,
            @Valid @RequestBody ModifyMovementAddress modifyMovementAddress,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        service.modifyHouseholdMovementAddress(household, dateTime, modifyMovementAddress);
    }

    @DeleteMapping("/{reportDate}")
    @ResponseStatus(HttpStatus.OK)
    public void removeMovementAddress(@ModelAttribute("householdNo") Household household,
                                      @PathVariable("reportDate") LocalDate dateTime) {
        service.deleteMovementAddress(household, dateTime);
    }
}
