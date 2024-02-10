package com.omkar.mappingdemo.dto;


import com.omkar.mappingdemo.model.Country;

import lombok.Data;


@Data
public class StateDto {
     private int stateId;
    private String stateName;
    private Country country;
   
}
