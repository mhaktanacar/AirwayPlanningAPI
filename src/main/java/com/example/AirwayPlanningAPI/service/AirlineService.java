package com.example.AirwayPlanningAPI.service;

import com.example.AirwayPlanningAPI.entity.Airline;

import java.util.List;

/**
 * Created by MHAKTANACAR on 19.06.2022
 */
public interface AirlineService
{
    Airline saveAirline(Airline airline);

    List<Airline> fetchAirlineList();

    Airline updateAirline(Airline airline, Long airlineId);

    void deleteAirlineById(Long airlineId);
}
