package com.example.AirwayPlanningAPI.mapper;

import com.example.AirwayPlanningAPI.dto.AirportDto;
import com.example.AirwayPlanningAPI.entity.Airport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Created by MHAKTANACAR on 23.06.2022
 */
@Mapper(componentModel = "spring")
public interface AirportMapper
{
    @Mapping(source = "airportCode", target = "airportCode")
    AirportDto toDto(Airport airport);
}
