package com.example.REST.controller;


import com.example.REST.entity.Company;
import com.example.REST.service.AdvertiserService;
import com.example.REST.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    // delete COMPANY
    @GetMapping("/news/campaigns/delete/{id}")
    public String deleteCampaign(@PathVariable(value = "id") long id) {
        companyService.softDelete(id);
        return "redirect:/news";
    }

    // save edit company
    @RequestMapping(value = "/news/campaigns/edit/save_edit", method = RequestMethod.POST)
    public String saveEditCampaign(@ModelAttribute("campaign") Company company) {
        companyService.save(company);
        return "redirect:/news";
    }

    //edit company
    @GetMapping("/news/campaigns/edit/{id}")
    public  String editCampaign(@PathVariable(value = "id") long id, Model model){
        Company company= companyService.get(id);
        model.addAttribute("campaign", company);
        return "edit_campaigns";
    }

    //new COMPANY
    @GetMapping("/news/campaigns/new/{advertiser_id}")
    private String newCompany(@PathVariable(value = "advertiser_id") long id, Map<String, Object> model){
        Company company = new Company();
        company.setAdvertisers(advertiserService.get(id));
        model.put("company", company);
        return "new_campaigns";
    }

    // save COMPANY
    @RequestMapping(value = "/news/campaigns/new/save", method = RequestMethod.POST)
    public String saveCampaign(@ModelAttribute("company") Company company) {
        companyService.save(company);
        return "redirect:/news";
    }



    /*
    @GetMapping("/news/campaigns/{id}")
    public String companyView(@PathVariable(value = "id") long id, Model model){
        return findPaginated(1,id,model);
    }

    @GetMapping("/news/campaigns/{pageNumber}/{id}")
    public String findPaginated(@PathVariable(value = "pageNumber")int pageNo,
                                @PathVariable(value = "id") long idA,
                                Model model){
        int pageSize = 5;
        Page<Company> page = companyService.findPaginate(pageNo,pageSize);
        List<Company> companyList = page.getContent();
        companyList.removeIf(company -> company.getAdvertisers().getId() == idA);


        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listCompany", companyList);
        return "company1";
    }
*/

}
