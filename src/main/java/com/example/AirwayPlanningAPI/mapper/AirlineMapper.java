package com.example.AirwayPlanningAPI.mapper;

import com.example.AirwayPlanningAPI.dto.AirlineDto;
import com.example.AirwayPlanningAPI.entity.Airline;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Created by MHAKTANACAR on 23.06.2022
 */
@Mapper(componentModel = "spring")
public interface AirlineMapper
{
    @Mapping(source = "airlineCode", target = "airlineCode")
    AirlineDto toDto(Airline airline);
}
