package com.nhnacademy.certificate.controller;

import com.nhnacademy.certificate.service.HouseholdService;
import com.nhnacademy.certificate.service.ResidentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/delete")
public class DeleteController {
    private HouseholdService householdService;
    private ResidentService residentService;
    @GetMapping("{residentNo}")
    public String doDeleteResident(@PathVariable("residentNo") Integer residentNo,
                                   Model model) {
        if (householdService.checkHouseholder(residentNo)) {
            model.addAttribute("checkDelete", true);

        }
        return "redircet:/residents";
    }
}
