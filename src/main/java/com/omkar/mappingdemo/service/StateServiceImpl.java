package com.omkar.mappingdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.omkar.mappingdemo.dto.StateDto;
import com.omkar.mappingdemo.exception.StateNotFoundException;
import com.omkar.mappingdemo.model.City;
import com.omkar.mappingdemo.model.Country;
import com.omkar.mappingdemo.model.State;
import com.omkar.mappingdemo.repository.CityRepository;
import com.omkar.mappingdemo.repository.StateRepository;

@Service
public class StateServiceImpl implements StateService {

    private StateRepository stateRepository;
    private CityRepository cityRepository;

    public StateServiceImpl(StateRepository stateRepository,CityRepository  cityRepository) {
        this.stateRepository = stateRepository;
        this.cityRepository=cityRepository;
    }
//
//    @Override
//    public List<StateDto> getAllStatesByCountry(int countryId) {
//        List<State> states = stateRepository.findStatesByCountryId(countryId);
//        List<StateDto> stateDtos = new ArrayList<>();
//        for (State state : states) {
//            StateDto stateDto = new StateDto();
//            stateDto.setStateId(state.getStateId());
//            stateDto.setStateName(state.getStateName());
//            stateDto.setCountry(state.getCountry());
//            stateDtos.add(stateDto);
//        }
//        return stateDtos;
//    }

    @Override
    public StateDto getStateById(int stateId) {
        State state= stateRepository.findById(stateId).orElseThrow(()->new StateNotFoundException("State Not Found With Id: "+stateId));
        StateDto stateDto=new StateDto();
        stateDto.setStateId(state.getStateId());
        stateDto.setStateName(state.getStateName());
     
        return stateDto;
    }

    @Override
    public void addstate(StateDto stateDto,int countryId) {
        State state= new State();
        state.setStateId(stateDto.getStateId());
        state.setStateName(stateDto.getStateName());
        state.setCountry(new Country(countryId, ""));
      
        stateRepository.save(state);
    }

    @Override
    public void deleteById(int stateId) {
        if(!stateRepository.existsById(stateId)){
            throw new StateNotFoundException("State Not Found With Id: "+stateId);
        }
        List<City>  cities= cityRepository.findCitiesByStateId(stateId);
        cityRepository.deleteAll(cities);
        stateRepository.deleteById(stateId);
    }

	@Override
	public List<StateDto> getAllStatesByCountry(int countryId) {
		return stateRepository.find(countryId);
	}

}
