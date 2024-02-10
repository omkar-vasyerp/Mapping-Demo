package com.omkar.mappingdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.omkar.mappingdemo.model.City;


@Repository
public interface CityRepository extends  JpaRepository<City,Integer>{
    
    @Query(value = "select * from city c where c.state_id=?1", nativeQuery = true)
    public  List<City> findCitiesByStateId(int stateId) ;
        
}
