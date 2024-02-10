package com.omkar.mappingdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="state_id")
    private int stateId;
    @Column(name="state_name")
    private String stateName;
    @ManyToOne
    @JoinColumn(name="country_id",referencedColumnName="country_id")
    private Country country;
    public State(int stateId, String stateName, Country country) {
        this.stateId = stateId;
        this.stateName = stateName;
        this.country = country;
    }
    

}

