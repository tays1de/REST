package com.example.REST.service;


import com.example.REST.entity.Advertiser;
import com.example.REST.entity.Company;
import com.example.REST.repository.AdvertiserRepository;
import com.example.REST.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdvertiserService {

    @Autowired
    AdvertiserRepository repo;

    @Autowired
    CompanyRepository companyRepository;

    public void save(Advertiser customer) {
        repo.save(customer);
    }

    public List<Advertiser> listAll() {
        return (List<Advertiser>) repo.findAll();
    }

    public Advertiser get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        for (Company company:
                companyRepository.findAll()  ) {
            if(company.getAdvertisers().getId()==id){
                companyRepository.delete(company);
            }
        }
        repo.deleteById(id);
    }

}
