package com.nhnacademy.certificate.controller;

import com.nhnacademy.certificate.dto.FamilyRelationshipDTO;
import com.nhnacademy.certificate.service.CertificateIssueService;
import com.nhnacademy.certificate.service.FamilyRelationshipService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/familyRelationShipCertificate")
public class FamilyCertificateController {
    private final CertificateIssueService service;
    private final FamilyRelationshipService familyRelationshipService;

    public FamilyCertificateController(
        CertificateIssueService service, FamilyRelationshipService familyRelationshipService) {
        this.service = service;
        this.familyRelationshipService = familyRelationshipService;
    }

    @GetMapping
    public String familyCertificateView(@RequestParam("residentNo") Integer residentNo,
                                        Model model) {
        List<FamilyRelationshipDTO> familyRelationships =
            familyRelationshipService.getFamilyCertificateInfo(residentNo);


        model.addAttribute("certi", service.findCertificateList(residentNo,"가족관계증명서"));
        model.addAttribute("fms", familyRelationships);
        service.creatCertificateIssue(residentNo, "가족관계증명서");

        return "familyCertificate";
    }
}
