package com.omkar.mappingdemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omkar.mappingdemo.dto.ResponseDto;
import com.omkar.mappingdemo.dto.StateDto;
import com.omkar.mappingdemo.model.Country;
import com.omkar.mappingdemo.service.StateService;

@RestController
@RequestMapping("/api/country/{countryId}")
public class StateController {
    
    private StateService stateService;
    public StateController(StateService stateService){
        this.stateService= stateService;
    }

    @GetMapping("/state")
    public ResponseDto getAllStatesByCountry(@PathVariable int countryId){
         List<StateDto> states = stateService.getAllStatesByCountry(countryId);
        return new ResponseDto(200, "SUCCESS", states);
    }
    @GetMapping("/state/{stateId}")
    public ResponseDto getStateById(@PathVariable int stateId){
        StateDto stateDto = stateService.getStateById(stateId);
        return new ResponseDto(200, "SUCCESS", stateDto);
    }

    @PostMapping("/state")
    public ResponseDto addState(@RequestBody StateDto stateDto,@PathVariable int countryId ){
        stateDto.setCountry(new Country(countryId, "null"));
        stateService.addstate(stateDto);
        return new ResponseDto(200, "SUCCESS", "ADD SUCCESSFULL");
    }
    
    @DeleteMapping("/state/{stateId}")
    public ResponseDto deleteStateById(@PathVariable int stateId){
        stateService.deleteById(stateId);
        return new ResponseDto(200, "SUCCESS", "DELETE SUCCESSFULL");
    }
}
