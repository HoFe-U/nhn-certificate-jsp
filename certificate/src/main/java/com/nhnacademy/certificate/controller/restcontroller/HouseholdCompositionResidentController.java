package com.nhnacademy.certificate.controller.restcontroller;

import com.nhnacademy.certificate.domain.HouseholdCompositionDelete;
import com.nhnacademy.certificate.domain.HouseholdCompositionRequest;
import com.nhnacademy.certificate.entity.Household;
import com.nhnacademy.certificate.entity.HouseholdCompositionResident;
import com.nhnacademy.certificate.exception.NoHouseholdException;
import com.nhnacademy.certificate.service.HouseholdCompositionResidentService;
import com.nhnacademy.certificate.service.HouseholdService;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("household/compositon/{householdSerialNumber}")
public class HouseholdCompositionResidentController {
    private final HouseholdCompositionResidentService service;
    private final HouseholdService householdService;

    public HouseholdCompositionResidentController(
        HouseholdCompositionResidentService service,
        HouseholdService householdService) {
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public HouseholdCompositionResident createHouseholdCompositon(
        @ModelAttribute Household household,
        @RequestBody HouseholdCompositionRequest request,
        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        return service.createCompositionResident(household, request);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping
    public void removeHouseholdCompositionResident(@ModelAttribute Household household,
                                                    @Valid @RequestBody HouseholdCompositionDelete delete,
                                                    BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        service.deleteCompositionResident(household,delete);
    }
}
