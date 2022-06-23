package com.example.AirwayPlanningAPI.service;

import com.example.AirwayPlanningAPI.constants.Constants;
import com.example.AirwayPlanningAPI.entity.Flight;
import com.example.AirwayPlanningAPI.exception.FlightRestrictionException;
import com.example.AirwayPlanningAPI.exception.SourceDestinationErrorException;
import com.example.AirwayPlanningAPI.repository.flight.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by MHAKTANACAR on 19.06.2022
 */
@Service
public class FlightServiceImpl implements FlightService
{
    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Flight saveFlight(Flight flight)
    {
        checkSourceAndDestAirports(flight);
        checkAvailableFlightAndGetCount(flight);
        flight.setAirline(flight.getAirline());
        flight.setSourceAirport(flight.getSourceAirport());
        flight.setDestAirport(flight.getDestAirport());
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> fetchFlightList()
    {
        return (List<Flight>) flightRepository.findAll();
    }

    @Override
    public void deleteFlightById(Long flightId)
    {
        flightRepository.deleteById(flightId);
    }

    @Override
    public List<Flight> findTodaysFlight()
    {
        return flightRepository.findTodaysFlight();
    }

    @Override
    public List<Flight> getFlightByAirlineId(long airlineId)
    {
        return flightRepository.getFlightByAirlineId(airlineId);
    }

    @Override
    public List<Flight> getFlightByAirportId(long airportId)
    {
        return flightRepository.getFlightByAirportId(airportId);
    }

    @Override
    public List<Flight> getFlightsByDate(Date date)
    {
        return flightRepository.getFlightsByDate(date);
    }

    private void checkAvailableFlightAndGetCount(Flight flight)
    {
        if ((flightRepository.checkThatDaysFlightCount(flight.getFlightDate()
                , flight.getSourceAirport().getId()
                , flight.getDestAirport().getId()
                , flight.getAirline().getId()).size() >= 3))
        {
            throw new FlightRestrictionException(Constants.FLIGHT_RESTRICTION);
        }
    }

    private void checkSourceAndDestAirports(Flight flight)
    {
        if (flight.getSourceAirport().getId() == flight.getDestAirport().getId())
        {
            throw new SourceDestinationErrorException(Constants.SOURCE_DEST_ERROR);
        }
    }
}
