package com.example.AirwayPlanningAPI.exception;

/**
 * Created by MHAKTANACAR on 19.06.2022
 */
public class SourceDestinationErrorException extends RuntimeException
{
    public SourceDestinationErrorException(String message)
    {
        super(message);
    }
}
