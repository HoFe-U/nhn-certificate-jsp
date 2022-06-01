package com.nhnacademy.certificate.controller;

import com.nhnacademy.certificate.dto.FamilyHouseMemberDTO;
import com.nhnacademy.certificate.service.CertificateIssueService;
import com.nhnacademy.certificate.service.FamilyRelationshipService;
import com.nhnacademy.certificate.service.HouseholdService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/registCertification")
public class RegistraionCertificateController {
    private final CertificateIssueService certificateIssueService;
    private final HouseholdService householdService;
    private final FamilyRelationshipService familyRelationshipService;

    public RegistraionCertificateController(CertificateIssueService certificateIssueService,
                                            HouseholdService householdService,
                                            FamilyRelationshipService familyRelationshipService) {
        this.certificateIssueService = certificateIssueService;
        this.householdService = householdService;
        this.familyRelationshipService = familyRelationshipService;
    }

    @GetMapping
    public String registraitonView(@RequestParam("residentNo") Integer residentNo,
                                   Model model) {
        List<FamilyHouseMemberDTO> members =
            familyRelationshipService.getHouseMovementMembers(residentNo);

        if (members.isEmpty()) {
            return "redirect:/residents";
        }
        model.addAttribute("members", members);
        model.addAttribute("certi", certificateIssueService.findCertificate("주민등록등본"));
        model.addAttribute("household", householdService.findHouseholdGetDTO(residentNo));


        return "registraionCertificate";
    }
}
