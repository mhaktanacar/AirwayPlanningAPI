package com.example.AirwayPlanningAPI.mapper;

import com.example.AirwayPlanningAPI.dto.FlightDto;
import com.example.AirwayPlanningAPI.entity.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Created by MHAKTANACAR on 23.06.2022
 */
@Mapper(componentModel = "spring")
public interface FlightMapper
{
    @Mapping(source = "sourceAirport.airportCode", target = "FlightDto.sourceAirport")
    @Mapping(source = "destAirport.airportCode", target = "FlightDto.destAirport")
    @Mapping(source = "airline.airlineCode", target = "FlightDto.airlineCode")
    FlightDto toDto(Flight flight);

    Flight toEntity(FlightDto flightDto);
}
