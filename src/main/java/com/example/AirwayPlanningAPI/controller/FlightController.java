package com.example.AirwayPlanningAPI.controller;

import com.example.AirwayPlanningAPI.dto.FlightDto;
import com.example.AirwayPlanningAPI.entity.Flight;
import com.example.AirwayPlanningAPI.mapper.FlightMapper;
import com.example.AirwayPlanningAPI.service.AirlineService;
import com.example.AirwayPlanningAPI.service.AirportService;
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
import java.util.stream.Collectors;

/**
 * Created by MHAKTANACAR on 19.06.2022
 */
@RestController
public class FlightController
{
    @Autowired
    private FlightService flightService;

    @Autowired
    private AirportService airportService;

    @Autowired
    private AirlineService airlineService;

    @Autowired
    private FlightMapper flightMapper;

    @PostMapping("/flights")
    public Flight saveFlight(@RequestBody FlightDto flightDto)
    {
        Flight flight = flightMapper.toEntity(flightDto);
        return flightService.saveFlight(flight);
    }

    @GetMapping("/flights")
    public List<FlightDto> fetchFlightList()
    {
        return flightService.fetchFlightList()
                .stream()
                .map(flight -> flightMapper.toDto(flight))
                .collect(Collectors.toList());
    }

    @GetMapping("/todaysFlights")
    public List<FlightDto> findTodaysFlight()
    {
        return flightService.findTodaysFlight()
                .stream()
                .map(flight -> flightMapper.toDto(flight))
                .collect(Collectors.toList());
    }

    @GetMapping("/flights/date/{date}")
    public List<FlightDto> findTodaysFlight(@PathVariable("date")
                                                    Date date)
    {
        return flightService.getFlightsByDate(date)
                .stream()
                .map(flight -> flightMapper.toDto(flight))
                .collect(Collectors.toList());
    }

    @GetMapping("/flights/airline/{airlineCode}")
    public List<FlightDto> getFlightsByAirlineCode(@PathVariable("airlineCode")
                                                           String airlineCode)
    {
        return flightService.getFlightByAirlineId(airlineService.findAirlineByAirlineCode(airlineCode).getId())
                .stream()
                .map(flight -> flightMapper.toDto(flight))
                .collect(Collectors.toList());
    }

    @GetMapping("/flights/airport/{airportCode}")
    public List<FlightDto> getFlightByAirportCode(@PathVariable("airportCode")
                                                          String airportCode)
    {
        return flightService.getFlightByAirportId(airportService.findAirportByAirportCode(airportCode).getId())
                .stream()
                .map(flight -> flightMapper.toDto(flight))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/flights/{id}")
    public String deleteFlightById(@PathVariable("id")
                                           Long flightId)
    {
        flightService.deleteFlightById(flightId);
        return "Deleted Successfully";
    }
}
