package com.nhnacademy.certificate.controller;

import com.nhnacademy.certificate.service.CertificateIssueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/familyRelationShipCertificate/{residentNo}")
public class FamilyCertificateController {
    private final CertificateIssueService service;

    public FamilyCertificateController(
        CertificateIssueService service) {
        this.service = service;
    }


    @GetMapping
    public String familyCertificateView(@PathVariable("residentNo") Integer residentNo,
                                        Model model){
        service.findFamilyCertificateUpper(residentNo);

        return "familyCertificate";
    }
}
