package com.example.AirwayPlanningAPI.controller;

import com.example.AirwayPlanningAPI.dto.AirportDto;
import com.example.AirwayPlanningAPI.mapper.AirportMapper;
import com.example.AirwayPlanningAPI.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by MHAKTANACAR on 19.06.2022
 */
@RestController
public class AirportController
{
    @Autowired
    private AirportService airportService;

    @Autowired
    private AirportMapper airportMapper;

    @GetMapping("/airports")
    public List<AirportDto> fetchAirportList()
    {
        return airportService.fetchAirportList()
                .stream()
                .map(airport -> airportMapper.toDto(airport))
                .collect(Collectors.toList());
    }
}
