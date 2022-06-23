package com.example.AirwayPlanningAPI.service;

import com.example.AirwayPlanningAPI.entity.Airline;

import java.util.List;

/**
 * Created by MHAKTANACAR on 19.06.2022
 */
public interface AirlineService
{
    List<Airline> fetchAirlineList();

    Airline findAirlineByAirlineCode(String airlineCode);
}
