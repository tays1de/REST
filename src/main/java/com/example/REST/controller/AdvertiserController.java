package com.example.REST.controller;


import com.example.REST.entity.Advertiser;
import com.example.REST.service.AdvertiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class AdvertiserController {


    @Autowired
    private AdvertiserService advertiserService;


/*
    @GetMapping("/news")
    public String get_news(Model model) {
        model.addAttribute("advertiserList", advertiserService.listAll());
        return ("news");
    }
*/


    @GetMapping("/news")
    public String companyView(Model model){
        return findPaginated(1, "id","asc",model);
    }

    @GetMapping("/news/{pageNumber}")
    public String findPaginated(@PathVariable(value = "pageNumber")int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;
        System.out.println("!!!!!!!!!!!!!!!!!!!!!" + sortField + "!!!!!!!!!!!!!!!!!!!!!!!!");
        Page<Advertiser> page = advertiserService.findPaginated(pageNo, pageSize,sortField,sortDir);

        List<Advertiser> advertiserList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listAdvertiser", advertiserList);

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        return "news1";
    }



    // delete ADVERTISER
    @GetMapping("/news/delete")
    public String deleteAdvertiser(@RequestParam long id) {
        advertiserService.delete(id);
        return "redirect:/news";
    }
    // new ADVERTISER
    @GetMapping("/news/new")
    public String newsAdvertiserForm(Map<String, Object> model) {
        Advertiser advertiser = new Advertiser();
        model.put("advertiser", advertiser);
        return "new_advertiser";
    }
    // save ADVERTISER
    @PostMapping("/news/save")
    public String saveNewAdvertiser(@ModelAttribute("customer") Advertiser advertiser) {
        advertiserService.save(advertiser);
        return "redirect:/news";
    }
    // save edit ADVERTISER
    @PostMapping("/news/save_edit")
    public String saveEditAdvertiser(@ModelAttribute("customer") Advertiser advertiser) {
        advertiserService.save(advertiser);
        return "redirect:/news";
    }
    // edit ADVERTISER
    @GetMapping("/news/edit")
    public String editAdvertiser(@RequestParam Long id, Model model) {
        Advertiser advertiser = advertiserService.get(id);
        model.addAttribute("advertiser", advertiser);
        return "edit_advertiser";
    }


}
