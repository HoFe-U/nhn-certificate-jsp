package com.nhnacademy.certificate.controller;

import com.nhnacademy.certificate.dto.CertificateIssueDTO;
import com.nhnacademy.certificate.service.CertificateIssueService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        //TODO : 중복코드
        Page<CertificateIssueDTO> reportList = certificateIssueService.findCertificateList(
            PageRequest.of(currentPage - 1, pageSize),residentNo);
        model.addAttribute("reports", reportList);

        int totalPages = reportList.getTotalPages();

        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("pages", reportList);
        model.addAttribute("maxPage", 5);
        model.addAttribute("residentNo", residentNo);

        return "certificateListForm";
    }
}
