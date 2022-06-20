package com.example.AirwayPlanningAPI.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Created by MHAKTANACAR on 19.06.2022
 */
public class ExceptionResponse
{
    @Getter
    @Setter
    private String errorMessage;
    @Getter
    @Setter
    private String errorCode;
    @Getter
    @Setter
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

}
