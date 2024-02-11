package com.omkar.mappingdemo.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.omkar.mappingdemo.model.Country;

import lombok.Data;


@Data
public class StateDto {
     private int stateId;
    private String stateName;
    @JsonIgnore
    private Country country;
   
}
