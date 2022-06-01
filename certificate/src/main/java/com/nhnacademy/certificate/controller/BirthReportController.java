package com.nhnacademy.certificate.controller;

import com.nhnacademy.certificate.dto.DeathDTO;
import com.nhnacademy.certificate.service.BirthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/brithReport")
public class BirthReportController {
    private final BirthService birthService;

    public BirthReportController(BirthService birthService) {
        this.birthService = birthService;
    }


    @GetMapping
    public String lookBirthReport(@RequestParam("residentNo") Integer residentNo,
                                  Model model) {
        model.addAttribute("birth", birthService.findBrithReport(residentNo, "출생"));
        model.addAttribute("father",birthService.findMotherOrFather(residentNo, "부"));
        model.addAttribute("mother",birthService.findMotherOrFather(residentNo, "모"));

        return "birthReport";
    }
}
