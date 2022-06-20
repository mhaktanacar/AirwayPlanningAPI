package com.example.AirwayPlanningAPI.service;

import com.example.AirwayPlanningAPI.constants.Constants;
import com.example.AirwayPlanningAPI.entity.Flight;
import com.example.AirwayPlanningAPI.exception.FlightRestrictionException;
import com.example.AirwayPlanningAPI.exception.SourceDestinationErrorException;
import com.example.AirwayPlanningAPI.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        try
        {
            List<Flight> flightList = (List<Flight>) flightRepository.getFlightsByDate(flight.getFlightDate());
            String newSourceDest = prepareSourceDestString(flight);
            List<String> sourceDestList = new ArrayList<>();

            int count = 0;
            count = getCount(flightList, newSourceDest, sourceDestList, count);
            if (count >= 3)
            {
                throw new FlightRestrictionException(Constants.FLIGHT_RESTRICTION);
            }

            if (flight.getSourceAirport().getId() == flight.getDestAirport().getId())
            {
                throw new SourceDestinationErrorException(Constants.SOURCE_DEST_ERROR);
            }

            flight.setAirline(flight.getAirline());
            flight.setSourceAirport(flight.getSourceAirport());
            flight.setDestAirport(flight.getDestAirport());
            return flightRepository.save(flight);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
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

    private int getCount(List<Flight> flightList, String newSourceDest, List<String> sourceDestList, int count)
    {
        for (Flight flights : flightList)
        {
            sourceDestList.add(prepareSourceDestString(flights));
        }
        for (int i = 0; i < sourceDestList.size(); i++)
        {
            if (newSourceDest.equals(sourceDestList.get(i)))
            {
                count++;
            }
        }
        return count;
    }

    private String prepareSourceDestString(Flight flights)
    {
        if (flights.getSourceAirport().getId() > flights.getDestAirport().getId())
        {
            return Long.toString(flights.getAirline().getId())
                    .concat(Long.toString(flights.getDestAirport().getId())
                            .concat(Long.toString(flights.getSourceAirport().getId())));
        }
        else if (flights.getSourceAirport().getId() < flights.getDestAirport().getId())
        {
            return Long.toString(flights.getAirline().getId())
                    .concat(Long.toString(flights.getSourceAirport().getId())
                            .concat(Long.toString(flights.getDestAirport().getId())));
        }
        else if (flights.getSourceAirport().getId() == flights.getDestAirport().getId())
        {
            return Long.toString(flights.getAirline().getId())
                    .concat(Long.toString(flights.getSourceAirport().getId())
                            .concat(Long.toString(flights.getDestAirport().getId())));
        }
        else return null;
    }
}
