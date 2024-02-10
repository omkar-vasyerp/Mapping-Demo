package com.omkar.mappingdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omkar.mappingdemo.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer>{
    
}
