package com.example.REST.controller;


import com.example.REST.entity.AdvertiserCompany;
import com.example.REST.entity.Company;
import com.example.REST.service.AdverCompService;
import com.example.REST.service.AdvertiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class AdverCompController {

    @Autowired
    private AdverCompService adverCompService;

    @Autowired
    private AdvertiserService advertiserService;

    @GetMapping("/news/advercomp/{id}")
    private String getAdverComp(@PathVariable(name = "id") long id, Model model){
        model.addAttribute("adverComp", adverCompService.listOfAdverComp(id));
        model.addAttribute("advertiser_id", id);
        return "adver_comp";
    }

    @GetMapping("/news/advercomp/new/{advertiser_id}")
    private String newAdverCompany(@PathVariable(value = "advertiser_id") long id, Map<String, Object> model){
        AdvertiserCompany advertiserCompany = new AdvertiserCompany();
        advertiserCompany.setAdvertisers(advertiserService.get(id));
        model.put("adverComp", advertiserCompany);
        return "new_adver_comp";
    }

    @RequestMapping(value = "/news/advercomp/new/save", method = RequestMethod.POST)
    public String saveAdverCompany(@ModelAttribute("adverComp") AdvertiserCompany advertiserCompany) {
        adverCompService.save(advertiserCompany);
        return "redirect:/news";
    }

    @GetMapping("/news/advercomp/delete/{id}")
    public String deleteAdverCompany(@PathVariable(value = "id") long id) {
        adverCompService.delete(id);
        return "redirect:/news";
    }

    @RequestMapping(value = "/news/advercomp/edit/save_edit", method = RequestMethod.POST)
    public String saveEditAdverCompany(@ModelAttribute("adverComp") AdvertiserCompany advertiserCompany) {
        adverCompService.save(advertiserCompany);
        return "redirect:/news";
    }

    @GetMapping("/news/advercomp/edit/{id}")
    public  String editAdverCompany(@PathVariable(value = "id") long id, Model model){
        AdvertiserCompany advertiserCompany= adverCompService.get(id);
        model.addAttribute("adverComp", advertiserCompany);
        return "edit_adver_comp";
    }


}
