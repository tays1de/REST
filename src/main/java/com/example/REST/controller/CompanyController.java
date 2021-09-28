package com.example.REST.controller;


import com.example.REST.entity.Advertiser;
import com.example.REST.entity.Company;
import com.example.REST.service.AdvertiserService;
import com.example.REST.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private AdvertiserService advertiserService;

    @GetMapping("/news/campaigns/{id}")
    private String getCompanies(@PathVariable("id") long id, Model model){
        model.addAttribute("plzDo", companyService.listOfAdverister(id));
        model.addAttribute("advertiser_id", id);
        return "campaigns";
    }

    @GetMapping("/news/campaigns/delete/{id}")
    public String deleteCampaign(@PathVariable(value = "id") long id) {
        companyService.delete(id);
        return "redirect:/news";
    }

    @RequestMapping(value = "/news/campaigns/edit/save_edit", method = RequestMethod.POST)
    public String saveEditCampaign(@ModelAttribute("campaign") Company company) {
        companyService.save(company);
        return "redirect:/news";
    }

    @GetMapping("/news/campaigns/edit/{id}")
    public  String editCampaign(@PathVariable(value = "id") long id, Model model){
        Company company= companyService.get(id);
        model.addAttribute("campaign", company);
        return "edit_campaigns";
    }

    @GetMapping("/news/campaigns/new/{advertiser_id}")
    private String newCompany(@PathVariable(value = "advertiser_id") long id, Map<String, Object> model){
        Company company = new Company();
        company.setAdvertisers(advertiserService.get(id));
        model.put("company", company);
        return "new_campaigns";
    }

    @RequestMapping(value = "/news/campaigns/new/save", method = RequestMethod.POST)
    public String saveCampaign(@ModelAttribute("company") Company company) {
        companyService.save(company);
        return "redirect:/news";
    }
}
