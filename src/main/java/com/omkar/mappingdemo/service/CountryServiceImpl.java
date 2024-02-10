package com.omkar.mappingdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.omkar.mappingdemo.dto.CountryDto;
import com.omkar.mappingdemo.exception.CountryNotFoundException;
import com.omkar.mappingdemo.model.Country;
import com.omkar.mappingdemo.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService{

    private  CountryRepository countryRepository;
    public CountryServiceImpl(CountryRepository countryRepository){
        this.countryRepository=countryRepository;

        
    }
    @Override
    public List<CountryDto> getAllCountries() {
        List<Country> countries = countryRepository.findAll();
        List<CountryDto> CountryDtos= new ArrayList<>();
        for (Country country : countries) {
            CountryDto countryDto = new CountryDto();
            countryDto.setCountryId(country.getCountryId());
            countryDto.setCountryName(country.getCountryName());
            CountryDtos.add(countryDto);
        }
        return CountryDtos;
    }
    @Override
    public CountryDto getCountryById(int countryId) {
        Country country= countryRepository.findById(countryId).orElseThrow(()->new CountryNotFoundException("Country Not Found With Id: "+countryId));
        CountryDto countryDto = new CountryDto();
            countryDto.setCountryId(country.getCountryId());
            countryDto.setCountryName(country.getCountryName());
            return countryDto;
    }
    @Override
    public void addCountry(CountryDto countryDto) {
        Country country =new Country();
        country.setCountryId(countryDto.getCountryId());
        country.setCountryName(countryDto.getCountryName());
        countryRepository.save(country);
    }
    @Override
    public void deleteById(int countryId) {
       if (!countryRepository.existsById(countryId)) {
        throw new CountryNotFoundException("Country Not Found With Id: "+countryId);
       }
       countryRepository.deleteById(countryId);
    }
    
} 
