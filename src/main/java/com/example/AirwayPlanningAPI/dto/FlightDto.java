package com.example.AirwayPlanningAPI.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by MHAKTANACAR on 23.06.2022
 */
@Data
@Getter
@Setter
public class FlightDto
{
    private String id;
    private String flightNumber;
    private Date flightDate;
    private String airlineCode;
    private String sourceAirport;
    private String destAirport;
}
