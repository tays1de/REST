package com.example.REST.repository;

import com.example.REST.entity.AdvertiserCompany;
import org.springframework.data.repository.CrudRepository;

public interface AdverCompRepository extends CrudRepository<AdvertiserCompany,Long> {
}
