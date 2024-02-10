package com.omkar.mappingdemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omkar.mappingdemo.dto.CountryDto;
import com.omkar.mappingdemo.dto.ResponseDto;
import com.omkar.mappingdemo.service.CountryService;

@RestController
@RequestMapping("/api")
public class CountryController {
    
    private CountryService countryService;
    public CountryController(CountryService countryService ){
        this.countryService=countryService;
    }

    @GetMapping("/country")
    public ResponseDto getAllCountries(){
        List<CountryDto> countries = countryService.getAllCountries();
        return new ResponseDto(200, "SUCCESS", countries);
    }
    
    @GetMapping("/country/{countryId}")
    public ResponseDto getCountryById(@PathVariable  int countryId){
        CountryDto countrydto = countryService.getCountryById(countryId);
        return new ResponseDto(200, "SUCCESS", countrydto);
    }

    @DeleteMapping("/country/{countryId}")
    public ResponseDto deleteCountryById(@PathVariable  int countryId){
        countryService.deleteById(countryId);
        return new ResponseDto(200, "SUCCESS", "DELETE SUCCESSFULL");
    }
    
    @PostMapping("/country")
    public ResponseDto addCountry(@RequestBody CountryDto countryDto){
        countryService.addCountry(countryDto);
        return new ResponseDto(200, "SUCCESS", "ADD SUCCESSFULL");
    }
}
