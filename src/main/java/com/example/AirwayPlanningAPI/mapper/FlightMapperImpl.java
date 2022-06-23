package com.example.AirwayPlanningAPI.mapper;

import com.example.AirwayPlanningAPI.dto.FlightDto;
import com.example.AirwayPlanningAPI.entity.Flight;
import com.example.AirwayPlanningAPI.repository.AirlineRepository;
import com.example.AirwayPlanningAPI.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by MHAKTANACAR on 23.06.2022
 */
@Component
public class FlightMapperImpl implements FlightMapper
{
    @Autowired
    private AirlineRepository airlineRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public FlightDto toDto(Flight flight)
    {
        if (flight == null)
        {
            return null;
        }
        FlightDto flightDto = new FlightDto();
        flightDto.setId(flight.getId());
        flightDto.setFlightNumber(flight.getFlightNumber());
        flightDto.setAirlineCode(flight.getAirline().getAirlineCode());
        flightDto.setDestAirport(flight.getDestAirport().getAirportCode());
        flightDto.setSourceAirport(flight.getSourceAirport().getAirportCode());
        flightDto.setFlightDate(flight.getFlightDate());
        return flightDto;
    }

    @Override
    public Flight toEntity(FlightDto flightDto)
    {

        if (flightDto == null)
        {
            return null;
        }
        Flight flight = new Flight();
        flight.setId(flightDto.getId());
        flight.setFlightNumber(flightDto.getFlightNumber());
        flight.setAirline(airlineRepository.findAirlineByAirlineCode(flightDto.getAirlineCode()));
        flight.setDestAirport(airportRepository.findAirportByAirportCode(flightDto.getDestAirport()));
        flight.setSourceAirport(airportRepository.findAirportByAirportCode(flightDto.getSourceAirport()));
        flight.setFlightDate(flightDto.getFlightDate());
        return flight;
    }
}
