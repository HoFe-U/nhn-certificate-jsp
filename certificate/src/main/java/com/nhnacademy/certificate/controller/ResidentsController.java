package com.nhnacademy.certificate.controller;

import com.nhnacademy.certificate.dto.ResidentDTO;
import com.nhnacademy.certificate.service.ResidentService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping
public class ResidentsController {
    private final ResidentService service;


    public ResidentsController(ResidentService service) {
        this.service = service;
    }

    @GetMapping(value = {"/", "/residents"})
    public String residentList(Model model,
                               @RequestParam("page") Optional<Integer> page,
                               @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<ResidentDTO> residents =
            service.getResidents(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("residents", residents);

        int totalPages = residents.getTotalPages();

        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        model.addAttribute("pages", residents);
        model.addAttribute("maxPage", 5);
        return "main";
    }
}
