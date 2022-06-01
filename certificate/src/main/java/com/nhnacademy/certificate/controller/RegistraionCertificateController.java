package com.nhnacademy.certificate.controller;

import com.nhnacademy.certificate.service.CertificateIssueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/registCertification")
public class RegistraionCertificateController {
    private final CertificateIssueService certificateIssueService;

    public RegistraionCertificateController(CertificateIssueService certificateIssueService) {
        this.certificateIssueService = certificateIssueService;
    }

    @GetMapping
    public String registraitonView(@RequestParam("residentNo") Integer residentNo,
                                   Model model){
        model.addAttribute("certi", certificateIssueService.findCertificate("주민등록등본"));

        return "registraionCertificate";
    }
}
