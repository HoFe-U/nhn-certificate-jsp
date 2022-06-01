package com.nhnacademy.certificate.controller;

import com.nhnacademy.certificate.dto.FamilyRelationshipDto;
import com.nhnacademy.certificate.entity.FamilyRelationship;
import com.nhnacademy.certificate.service.CertificateIssueService;
import com.nhnacademy.certificate.service.FamilyRelationshipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
                                        Model model){
        List<FamilyRelationshipDto> familyRelationshipDtos =familyRelationshipService.getFamilyCertificateInfo(residentNo);
        model.addAttribute("certi",service.findCertificate("가족관계증명서"));
        model.addAttribute("fms", familyRelationshipDtos);
        return "familyCertificate";
    }
}
