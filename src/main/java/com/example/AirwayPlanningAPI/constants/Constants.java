package com.example.AirwayPlanningAPI.constants;

import java.io.Serializable;

/**
 * Created by MHAKTANACAR on 19.06.2022
 */
public class Constants implements Serializable
{
    public static String FLIGHT_RESTRICTION = "There must be daily at most 3 flights for an airline between 2 destinations.";
    public static String FLIGHT_RESTRICTION_CODE = "FLIGHT RESTRICTION";
    public static String SOURCE_DEST_ERROR = "You can not choose the same airport for source and destination";
    public static String SOURCE_DEST_ERROR_CODE = "SOURCE DEST ERROR";
}
