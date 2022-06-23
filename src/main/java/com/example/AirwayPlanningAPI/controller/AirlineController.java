package com.example.AirwayPlanningAPI.controller;

import com.example.AirwayPlanningAPI.dto.AirlineDto;
import com.example.AirwayPlanningAPI.mapper.AirlineMapper;
import com.example.AirwayPlanningAPI.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by MHAKTANACAR on 19.06.2022
 */
@RestController
public class AirlineController
{
    @Autowired
    private AirlineService airlineService;

    @Autowired
    private AirlineMapper airlineMapper;

    @GetMapping("/airlines")
    public List<AirlineDto> fetchAirlineList()
    {
        return airlineService.fetchAirlineList()
                .stream()
                .map(airline -> airlineMapper.toDto(airline))
                .collect(Collectors.toList());
    }

    @GetMapping("/airlines/{code}")
    public AirlineDto findAirlineByAirlineCode(@PathVariable("code") String airlineCode)
    {
        return airlineMapper.toDto(airlineService.findAirlineByAirlineCode(airlineCode));
    }
}
