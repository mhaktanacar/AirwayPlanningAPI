package com.example.AirwayPlanningAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by MHAKTANACAR on 19.06.2022
 */

@Entity
@Table(name = "airport")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Airport
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "AIRPORT_CODE")
    private String airportCode;

    @JsonIgnore
    @OneToMany(mappedBy = "sourceAirport", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Flight> sourceFlightList;

    @JsonIgnore
    @OneToMany(mappedBy = "destAirport", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Flight> destFlightList;

}

