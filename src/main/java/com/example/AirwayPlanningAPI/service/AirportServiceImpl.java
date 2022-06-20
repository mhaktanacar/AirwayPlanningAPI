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
    public Airport saveAirport(Airport airport)
    {
        return airportRepository.save(airport);
    }

    @Override
    public List<Airport> fetchAirportList()
    {
        return (List<Airport>) airportRepository.findAll();
    }

    @Override
    public Airport updateAirport(Airport airport, Long airportId)
    {
        return null;
    }

    @Override
    public void deleteAirportById(Long airportId)
    {
        airportRepository.deleteById(airportId);
    }

}
