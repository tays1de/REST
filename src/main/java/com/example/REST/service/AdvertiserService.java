package com.example.REST.service;


import com.example.REST.entity.Advertiser;
import com.example.REST.repository.AdvertiserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdvertiserService {

    @Autowired
    AdvertiserRepository repo;

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
        repo.deleteById(id);
    }

}
