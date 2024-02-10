package com.omkar.mappingdemo.service;

import java.util.List;

import com.omkar.mappingdemo.dto.CountryDto;

public interface CountryService {
    List<CountryDto> getAllCountries();
    CountryDto getCountryById(int countryId);
    void addCountry(CountryDto countryDto);
    void deleteById(int countryId);
}
