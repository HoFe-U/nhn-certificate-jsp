package com.nhnacademy.certificate.controller.restcontroller;

import com.nhnacademy.certificate.domain.HouseholdRegister;
import com.nhnacademy.certificate.entity.Household;
import com.nhnacademy.certificate.service.HouseholdService;
import javax.validation.Valid;
import javax.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hosehold")
public class HouseholdController {
    private final HouseholdService service;

    public HouseholdController(HouseholdService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Household createHousehold(@Valid @RequestBody HouseholdRegister householdRegister,
                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        return service.createHousehold(householdRegister);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("{householdSerialNumber}")
    public void householdRemove(@PathVariable("householdSerialNumber") Integer serialNo){
        service.deleteHousehold(serialNo);
    }
}
