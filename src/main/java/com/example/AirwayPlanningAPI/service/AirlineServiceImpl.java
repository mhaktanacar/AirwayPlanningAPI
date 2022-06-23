package com.example.AirwayPlanningAPI.service;

import com.example.AirwayPlanningAPI.entity.Airline;
import com.example.AirwayPlanningAPI.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MHAKTANACAR on 19.06.2022
 */
@Service
public class AirlineServiceImpl implements AirlineService
{
    @Autowired
    private AirlineRepository airlineRepository;

    @Override
    public List<Airline> fetchAirlineList()
    {
        return (List<Airline>) airlineRepository.findAll();
    }

    @Override
    public Airline findAirlineByAirlineCode(String airlineCode)
    {
        return airlineRepository.findAirlineByAirlineCode(airlineCode);
    }
}
