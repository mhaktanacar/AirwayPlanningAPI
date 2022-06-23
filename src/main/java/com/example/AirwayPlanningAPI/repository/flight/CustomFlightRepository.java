package com.example.AirwayPlanningAPI.repository.flight;

import com.example.AirwayPlanningAPI.entity.Flight;

import java.util.Date;
import java.util.List;

/**
 * Created by MHAKTANACAR on 19.06.2022
 */
public interface CustomFlightRepository
{
    List<Flight> findTodaysFlight();

    List<Flight> getFlightByAirlineId(long airlineId);

    List<Flight> getFlightByAirportId(long airportId);

    List<Flight> getFlightsByDate(Date date);

    List<Flight> checkThatDaysFlightCount(Date date, long sourceAirportId, long destAirportId, long airlineId);
}
