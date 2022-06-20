package com.example.AirwayPlanningAPI.exception;

/**
 * Created by MHAKTANACAR on 19.06.2022
 */
public class FlightRestrictionException extends RuntimeException
{
    public FlightRestrictionException(String message)
    {
        super(message);
    }
}
