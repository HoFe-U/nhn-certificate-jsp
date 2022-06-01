package com.nhnacademy.certificate.controller;

import com.nhnacademy.certificate.dto.DeathDTO;
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

    public DeathReportController(DeathService deathService) {
        this.deathService = deathService;
    }

    @GetMapping
    public String lookDeathReport(@RequestParam("residentNo") Integer residentNo,
                                  Model model) {
        DeathDTO deathReport = deathService.findDeathReport(residentNo, "사망");
        model.addAttribute("death", deathReport);

        return "deathReport";
    }
}
