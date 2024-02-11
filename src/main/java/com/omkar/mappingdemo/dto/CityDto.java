package com.omkar.mappingdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.omkar.mappingdemo.model.State;

import lombok.Data;

@Data
public class CityDto {
    private int cityId;
    private String cityName;
    @JsonIgnore
    private State state;
}
