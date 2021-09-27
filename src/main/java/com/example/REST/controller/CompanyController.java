package com.example.REST.controller;


import com.example.REST.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/news/campaigns/{id}")
    private String getCompanies(@PathVariable("id") long id, Model model){
        model.addAttribute("plzDo", companyService.listOfAdverister(id));
        return "campaigns";
    }




}
