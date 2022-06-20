package com.example.AirwayPlanningAPI.service;

import com.example.AirwayPlanningAPI.entity.Flight;

import java.util.Date;
import java.util.List;

/**
 * Created by MHAKTANACAR on 19.06.2022
 */
public interface FlightService
{
    Flight saveFlight(Flight flight);

    List<Flight> fetchFlightList();

    void deleteFlightById(Long flightId);

    List<Flight> findTodaysFlight();

    List<Flight> getFlightByAirlineId(long airlineId);

    List<Flight> getFlightByAirportId(long airportId);

    List<Flight> getFlightsByDate(Date date);
}
