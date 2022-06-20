package com.example.AirwayPlanningAPI.controller;

import com.example.AirwayPlanningAPI.entity.Airport;
import com.example.AirwayPlanningAPI.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by MHAKTANACAR on 19.06.2022
 */
@RestController
public class AirportController
{
    @Autowired
    private AirportService airportService;

    @PostMapping("/airports")
    public Airport saveAirport(@RequestBody Airport airport)
    {
        return airportService.saveAirport(airport);
    }

    @GetMapping("/airports")
    public List<Airport> fetchAirportList()
    {
        return airportService.fetchAirportList();
    }

    @PutMapping("/airports/{id}")
    public Airport updateAirport(@RequestBody Airport airport, @PathVariable("id") Long airportId)
    {
        return airportService.updateAirport(airport, airportId);
    }

    @DeleteMapping("/airports/{id}")
    public String deleteAirportById(@PathVariable("id")
                                               Long airportId)
    {
        airportService.deleteAirportById(airportId);
        return "Deleted Successfully";
    }
}
