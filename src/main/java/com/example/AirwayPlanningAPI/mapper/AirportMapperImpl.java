package com.example.AirwayPlanningAPI.mapper;

import com.example.AirwayPlanningAPI.dto.AirportDto;
import com.example.AirwayPlanningAPI.entity.Airport;
import org.springframework.stereotype.Component;

/**
 * Created by MHAKTANACAR on 23.06.2022
 */
@Component
public class AirportMapperImpl implements AirportMapper
{
    @Override
    public AirportDto toDto(Airport airport)
    {
        if (airport == null)
        {
            return null;
        }
        AirportDto airportDto = new AirportDto();
        airportDto.setAirportCode(airport.getAirportCode());
        return airportDto;
    }
}
