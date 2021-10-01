package com.example.REST.service;


import com.example.REST.entity.AdvertiserCompany;
import com.example.REST.entity.Company;
import com.example.REST.repository.AdverCompRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AdverCompService {

    @Autowired
    AdverCompRepository adverCompRepository;

    public void save(AdvertiserCompany advertiserCompany) {
        adverCompRepository.save(advertiserCompany);
    }

    public List<AdvertiserCompany> listAll() {
        return (List<AdvertiserCompany>) adverCompRepository.findAll();
    }

    public List<AdvertiserCompany> listOfAdverComp(Long adverister_id) {
        List<AdvertiserCompany> advertiserCompanyList = (List<AdvertiserCompany>) adverCompRepository.findAll();
        List<AdvertiserCompany> result = new ArrayList<>();
        for (AdvertiserCompany advertiserCompany :
                advertiserCompanyList) {
            if (advertiserCompany.getAdvertisers().getId() == adverister_id) {
                result.add(advertiserCompany);
            }
        }
        return result;
    }

    public AdvertiserCompany get(Long id) {
        return adverCompRepository.findById(id).get();
    }

    public void delete(Long id) {
        adverCompRepository.deleteById(id);
    }



}
