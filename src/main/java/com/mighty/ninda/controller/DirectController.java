package com.mighty.ninda.controller;

import com.mighty.ninda.domain.direct.Direct;
import com.mighty.ninda.service.DirectService;
import com.mighty.ninda.service.ImpressionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
@Slf4j
public class DirectController {

    private final DirectService directService;
    private final ImpressionService impressionService;

    @GetMapping("/direct")
    public String directList(Model model) {
        model.addAttribute("directList", directService.findAll());
        return "direct/directList";
    }

    @GetMapping("/direct/{id}")
    public String direct(Model model, @PathVariable Long id) {
        Direct direct = directService.findById(id);
        model.addAttribute("direct", direct);
        model.addAttribute("impressions", impressionService.findAllImpressionByDirectId(direct.getId()));
        return "direct/direct";
    }

    @GetMapping("/direct/directForm")
    public String directForm() {
        return "direct/directForm";
    }
}