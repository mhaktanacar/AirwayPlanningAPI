package com.example.AirwayPlanningAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

import static com.example.AirwayPlanningAPI.constants.Constants.FLIGHT_RESTRICTION_CODE;
import static com.example.AirwayPlanningAPI.constants.Constants.SOURCE_DEST_ERROR_CODE;

/**
 * Created by MHAKTANACAR on 19.06.2022
 */
@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(FlightRestrictionException.class)
    public ResponseEntity<ExceptionResponse> flightRestrictionException(FlightRestrictionException ex)
    {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode(FLIGHT_RESTRICTION_CODE);
        response.setErrorMessage(ex.getMessage());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SourceDestinationErrorException.class)
    public ResponseEntity<ExceptionResponse> sourceDestinationErrorException(SourceDestinationErrorException ex)
    {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode(SOURCE_DEST_ERROR_CODE);
        response.setErrorMessage(ex.getMessage());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }
}
