package com.example.AirwayPlanningAPI.mapper;

import com.example.AirwayPlanningAPI.dto.AirlineDto;
import com.example.AirwayPlanningAPI.entity.Airline;
import org.springframework.stereotype.Component;

/**
 * Created by MHAKTANACAR on 23.06.2022
 */
@Component
public class AirlineMapperImpl implements AirlineMapper
{
    @Override
    public AirlineDto toDto(Airline airline)
    {
        if (airline == null)
        {
            return null;
        }
        AirlineDto airlineDto = new AirlineDto();
        airlineDto.setAirlineCode(airline.getAirlineCode());
        return airlineDto;
    }
}
