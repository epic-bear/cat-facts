package com.app.catfacts.controller;

import com.app.catfacts.service.CatFactService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatFactController {
    private final CatFactService catFactService;

    @Autowired
    public CatFactController(CatFactService catFactService) {
        this.catFactService = catFactService;
    }

    @GetMapping("/catfact")
    public String getFact(Model model) throws JsonProcessingException {
        String fact = catFactService.getCatFact();
        model.addAttribute("fact", fact);
        return "catfact";
    }
}
