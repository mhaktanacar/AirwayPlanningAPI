package com.example.AirwayPlanningAPI.controller;

import com.example.AirwayPlanningAPI.entity.Flight;
import com.example.AirwayPlanningAPI.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by MHAKTANACAR on 19.06.2022
 */
@RestController
public class FlightController
{
    @Autowired
    private FlightService flightService;

    @PostMapping("/flights")
    public Flight saveFlight(@RequestBody Flight flight)
    {
        return flightService.saveFlight(flight);
    }

    @GetMapping("/flights")
    public List<Flight> fetchFlightList()
    {
        return flightService.fetchFlightList();
    }

    @GetMapping("/todaysFlights")
    public List<Flight> findTodaysFlight()
    {
        return flightService.findTodaysFlight();
    }

    @GetMapping("/flights/date/{date}")
    public List<Flight> findTodaysFlight(@PathVariable("date")
                                                 Date date)
    {
        return flightService.getFlightsByDate(date);
    }

    @GetMapping("/flights/airline/{airlineId}")
    public List<Flight> getFlightByAirlineId(@PathVariable("airlineId")
                                                     Long airlineId)
    {
        return flightService.getFlightByAirlineId(airlineId);
    }

    @GetMapping("/flights/airport/{airportId}")
    public List<Flight> getFlightByAirportId(@PathVariable("airportId")
                                                     Long airportId)
    {
        return flightService.getFlightByAirportId(airportId);
    }

    @DeleteMapping("/flights/{id}")
    public String deleteFlightById(@PathVariable("id")
                                           Long flightId)
    {
        flightService.deleteFlightById(flightId);
        return "Deleted Successfully";
    }
}
