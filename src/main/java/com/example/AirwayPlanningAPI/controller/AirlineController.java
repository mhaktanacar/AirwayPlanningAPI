package com.example.AirwayPlanningAPI.controller;

import com.example.AirwayPlanningAPI.entity.Airline;
import com.example.AirwayPlanningAPI.service.AirlineService;
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
public class AirlineController
{
    @Autowired
    private AirlineService airlineService;

    @PostMapping("/airlines")
    public Airline saveAirline(@RequestBody Airline airline)
    {
        return airlineService.saveAirline(airline);
    }

    @GetMapping("/airlines")
    public List<Airline> fetchAirlineList()
    {
        return airlineService.fetchAirlineList();
    }

    @PutMapping("/airlines/{id}")
    public Airline updateAirline(@RequestBody Airline airline, @PathVariable("id") Long airlineId)
    {
        return airlineService.updateAirline(airline, airlineId);
    }

    @DeleteMapping("/airlines/{id}")
    public String deleteAirlineById(@PathVariable("id")
                                               Long airlineId)
    {
        airlineService.deleteAirlineById(airlineId);
        return "Deleted Successfully";
    }
}
