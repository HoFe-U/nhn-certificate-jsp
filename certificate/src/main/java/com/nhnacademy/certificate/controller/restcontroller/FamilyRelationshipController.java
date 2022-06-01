package com.nhnacademy.certificate.controller.restcontroller;

import com.nhnacademy.certificate.domain.FamilyRelationshipModify;
import com.nhnacademy.certificate.domain.FamilyRelationshipRegister;
import com.nhnacademy.certificate.entity.FamilyRelationship;
import com.nhnacademy.certificate.entity.Resident;
import com.nhnacademy.certificate.exception.NoResidentException;
import com.nhnacademy.certificate.service.FamilyRelationshipService;
import com.nhnacademy.certificate.service.ResidentService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.Objects;

@RestController
@RequestMapping("/residents/{serialNumber}")
public class FamilyRelationshipController {
    private final FamilyRelationshipService service;
    private final ResidentService residentService;

    public FamilyRelationshipController(FamilyRelationshipService service, ResidentService residentService) {
        this.service = service;
        this.residentService = residentService;
    }

    @ModelAttribute(value = "relationship", binding = false)
    public Integer checkSerialNo(@PathVariable("serialNumber") Integer serialNo) {
        if (Objects.isNull(residentService.getResident(serialNo))) {
            throw new NoResidentException();
        }
        return serialNo;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public FamilyRelationship createRelationship(@ModelAttribute("relationship") Integer serialNo,
                                                 @Valid @RequestBody FamilyRelationshipRegister familyRelationshipRegister,
                                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }

        return service.createRelationship(serialNo, familyRelationshipRegister);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/relationship/{familySerialNumber}")
    public void fixRelationship(@ModelAttribute("relationship") Integer serialNo,
                                              @PathVariable("familySerialNumber") Integer fmSerialNo,
                                              @Valid @RequestBody FamilyRelationshipModify familyRelationshipModify,
                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }

        service.modifyRelationship(serialNo, fmSerialNo, familyRelationshipModify);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/relationship/{familySerialNumber}")
    public void deleteRelationship(@ModelAttribute("relationship") Integer serialNo,
                                   @PathVariable("familySerialNumber") Integer fmSerialNo) {
        service.deleteRelationship(serialNo, fmSerialNo);
    }
}
