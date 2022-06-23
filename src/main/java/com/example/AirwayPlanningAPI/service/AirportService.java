package com.example.AirwayPlanningAPI.service;

import com.example.AirwayPlanningAPI.entity.Airport;

import java.util.List;

/**
 * Created by MHAKTANACAR on 19.06.2022
 */
public interface AirportService
{
    List<Airport> fetchAirportList();

    Airport findAirportByAirportCode(String airportCode);
}
