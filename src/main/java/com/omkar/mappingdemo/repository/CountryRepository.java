package com.omkar.mappingdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omkar.mappingdemo.model.Country;


public interface CountryRepository extends JpaRepository<Country,Integer>{
    
}
