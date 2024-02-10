package com.omkar.mappingdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="city_id")
    private int cityId;
    @Column(name="city_name")
    private String cityName;
    @ManyToOne
    @JoinColumn(name="state_id",referencedColumnName = "state_id")
    private State state;
   
}
