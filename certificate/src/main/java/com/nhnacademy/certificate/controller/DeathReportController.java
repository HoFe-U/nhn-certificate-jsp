package com.nhnacademy.certificate.controller;

import com.nhnacademy.certificate.dto.DeathDTO;
import com.nhnacademy.certificate.service.CertificateIssueService;
import com.nhnacademy.certificate.service.DeathService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/deathReport")
public class DeathReportController {
    private final DeathService deathService;
    private final CertificateIssueService certificateIssueService;
    
    public DeathReportController(DeathService deathService,
                                 CertificateIssueService certificateIssueService) {
        this.deathService = deathService;
        this.certificateIssueService = certificateIssueService;
    }

    @GetMapping
    public String lookDeathReport(@RequestParam("residentNo") Integer residentNo,
                                  Model model) {
        DeathDTO deathReport = deathService.findDeathReport(residentNo, "사망");
        certificateIssueService.creatCertificateIssue(residentNo,"사망신고서");
        
        model.addAttribute("death", deathReport);

        return "deathReport";
    }
}
