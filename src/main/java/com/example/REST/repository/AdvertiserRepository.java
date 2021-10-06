package com.example.REST.repository;

import com.example.REST.entity.Advertiser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AdvertiserRepository extends JpaRepository<Advertiser, Long> {
}
