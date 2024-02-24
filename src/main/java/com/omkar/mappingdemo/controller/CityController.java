package com.omkar.mappingdemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omkar.mappingdemo.dto.CityDto;
import com.omkar.mappingdemo.dto.ResponseDto;
import com.omkar.mappingdemo.model.State;
import com.omkar.mappingdemo.service.CityService;





@RestController
@RequestMapping("/api/country/{countryId}/state/{stateId}")
public class CityController {
    
    private CityService cityService;
    public CityController(CityService cityService ){
        this.cityService=cityService;
    }

    @GetMapping("/city")
    public ResponseDto getAllCitiesByStateId(@PathVariable int stateId) {
        List<CityDto> cities= cityService.getAllCitiesByState(stateId);
        return new ResponseDto(200,"Success",cities);
    }
    
    @GetMapping("/city/{cityId}")
    public ResponseDto getCityByID(@PathVariable int cityId) {
        CityDto citydto = cityService.getCityById(cityId);
        return new ResponseDto(200,"Success",citydto);
    }
    @PostMapping("/city")
    public ResponseDto addCity(@RequestBody CityDto cityDto,@PathVariable int stateId) {
       cityDto.setState(new State(stateId, "") );
       cityService.addCity(cityDto);
       return new ResponseDto(200,"Success","ADD Successfull");
    }
    
    @DeleteMapping("/city/{cityId}")
    public ResponseDto deleteCity(@PathVariable int cityId){
    	 try {
             cityService.deleteById(cityId);
             return new ResponseDto(200, "SUCCESS", "DELETE SUCCESSFUL");
         } catch (Exception e) {
             return new ResponseDto(500, "ERROR", "Failed to delete City: " + e.getMessage());
         }

    }

}
