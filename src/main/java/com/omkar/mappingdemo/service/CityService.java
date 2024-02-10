package com.omkar.mappingdemo.service;

import java.util.List;

import com.omkar.mappingdemo.dto.CityDto;

public interface CityService {
    List<CityDto> getAllCitiesByState(int stateId);
    CityDto getCityById(int cityId);
    void addCity(CityDto cityDto);
    void deleteById(int cityId);
}
