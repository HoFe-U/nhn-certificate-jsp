package com.nhnacademy.certificate.controller;

import com.nhnacademy.certificate.service.CertificateIssueService;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/certificateList")
public class CertificateListController {
    private final CertificateIssueService certificateIssueService;

    public CertificateListController(
        CertificateIssueService certificateIssueService) {
        this.certificateIssueService = certificateIssueService;
    }

    @GetMapping("/{residentNo}")
    public String showCertificateList(@PathVariable("residentNo") Integer residentNo,
                                      @RequestParam("page") Optional<Integer> page,
                                      @RequestParam("size") Optional<Integer> size,
                                      Model model) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);



        return "certificateListForm";
    }
}
