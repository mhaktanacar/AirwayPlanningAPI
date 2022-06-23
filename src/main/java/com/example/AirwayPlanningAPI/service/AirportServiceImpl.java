package com.example.AirwayPlanningAPI.service;

import com.example.AirwayPlanningAPI.entity.Airport;
import com.example.AirwayPlanningAPI.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MHAKTANACAR on 19.06.2022
 */
@Service
public class AirportServiceImpl implements AirportService
{
    @Autowired
    private AirportRepository airportRepository;

    @Override
    public List<Airport> fetchAirportList()
    {
        return (List<Airport>) airportRepository.findAll();
    }

    @Override
    public Airport findAirportByAirportCode(String airportCode)
    {
        return airportRepository.findAirportByAirportCode(airportCode);
    }
}
