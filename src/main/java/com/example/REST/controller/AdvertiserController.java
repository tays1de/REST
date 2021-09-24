package com.example.REST.controller;


import com.example.REST.entity.Advertiser;
import com.example.REST.service.AdvertiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class AdvertiserController {


    @Autowired
    private AdvertiserService advertiserService;


    @GetMapping("/news")
    public String get_news(Model model) {
        model.addAttribute("advertiserList", advertiserService.listAll());
        return ("news");
    }

    @GetMapping("/news/delete")
    public String deleteAdvertiser(@RequestParam Long id) {
        advertiserService.delete(id);
        return "redirect:/news";
    }

    @GetMapping("/news/new")
    public String newsAdvertiserForm(Map<String, Object> model) {
        Advertiser advertiser = new Advertiser();
        model.put("advertiser", advertiser);
        return "new_advertiser";
    }

    @PostMapping("/news/save")
    public String saveNewAdvertiser(@ModelAttribute("customer") Advertiser advertiser) {
        advertiser.setId(advertiserService.listAll().size() + 1);
        advertiserService.save(advertiser);
        return "redirect:/news";
    }

    @PostMapping("/news/save_edit")
    public String saveEditAdvertiser(@ModelAttribute("customer") Advertiser advertiser) {
        advertiserService.save(advertiser);
        return "redirect:/news";
    }


    @GetMapping("/news/edit")
    public  String editAdvertiser(@RequestParam Long id, Model model){

        Advertiser advertiser= advertiserService.get(id);
        model.addAttribute("advertiser", advertiser);
        return "edit_advertiser";
    }

}
