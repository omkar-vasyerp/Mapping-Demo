package com.omkar.mappingdemo.service;

import java.util.List;

import com.omkar.mappingdemo.dto.StateDto;

public interface StateService{
    // List<StateDto> getAllStates();
    List<StateDto> getAllStatesByCountry(int countryId);
    StateDto getStateById(int stateId);
    void addstate(StateDto stateDto);
    void deleteById(int stateId);
}
