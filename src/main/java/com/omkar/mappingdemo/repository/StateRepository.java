package com.omkar.mappingdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.omkar.mappingdemo.dto.StateDto;
import com.omkar.mappingdemo.model.State;


public interface StateRepository extends JpaRepository<State,Integer> {
   
    @Query(value = "select * from state s where s.country_id=?1", nativeQuery = true)
    public  List<State> findStatesByCountryId(int countryId);
    
    @Query("SELECT new  com.omkar.mappingdemo.dto.StateDto(s.stateId , s.stateName) FROM State s WHERE country.countryId = :id")
    public List<StateDto> find(@Param("id") int id);
}
