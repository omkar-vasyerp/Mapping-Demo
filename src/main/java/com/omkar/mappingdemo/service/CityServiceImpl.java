package com.omkar.mappingdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.omkar.mappingdemo.dto.CityDto;
import com.omkar.mappingdemo.exception.CityNotFoundException;
import com.omkar.mappingdemo.model.City;
import com.omkar.mappingdemo.repository.CityRepository;
@Service
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
    @Override
    public List<CityDto> getAllCitiesByState(int stateId) {
        List<City> cities = cityRepository.findCitiesByStateId(stateId);
        List<CityDto> cityDtos = new ArrayList<>();
        for (City city : cities) {
            CityDto cityDto = new CityDto();
            cityDto.setCityId(city.getCityId());
            cityDto.setCityName(city.getCityName());
            cityDto.setState(city.getState());
            cityDtos.add(cityDto);
        }
        return cityDtos;
    }
    @Override
    public CityDto getCityById(int cityId) {
       City city = cityRepository.findById(cityId).orElseThrow(()->  new CityNotFoundException("City Not Found with Id: "+cityId));
       CityDto cityDto = new CityDto();
            cityDto.setCityId(city.getCityId());
            cityDto.setCityName(city.getCityName());
            cityDto.setState(city.getState());
            return cityDto;
    }
    @Override
    public void addCity(CityDto cityDto) {
        City city= new City();
        city.setCityId(cityDto.getCityId());
        city.setCityName(cityDto.getCityName());
        city.setState(cityDto.getState());
        cityRepository.save(city);
    }
    @Override
    public void deleteById(int cityId) {
        if(!cityRepository.existsById(cityId)){
            throw new CityNotFoundException("City Not Found with Id: "+cityId);
        }
        cityRepository.deleteById(cityId);
    }

}
