package com.omkar.mappingdemo.dto;

import com.omkar.mappingdemo.model.State;

import lombok.Data;

@Data
public class CityDto {
    private int cityId;
    private String cityName;
    private State state;
}
