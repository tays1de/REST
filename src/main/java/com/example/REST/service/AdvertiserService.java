package com.example.REST.service;


import com.example.REST.entity.Advertiser;
import com.example.REST.entity.Company;
import com.example.REST.repository.AdvertiserRepository;
import com.example.REST.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Page<Advertiser> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.repo.findAll(pageable);
    }

    public List<Advertiser> listAll() {
        return (List<Advertiser>) repo.findAll();
    }

    public Advertiser get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        for (Company company :
                companyRepository.findAll()) {
            if (company.getAdvertisers().getId() == id) {
                companyRepository.delete(company);
            }
        }
        repo.deleteById(id);
    }

}
