package com.example.AirwayPlanningAPI.repository;

import com.example.AirwayPlanningAPI.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by TCMUACAR on 19.06.2022
 */
public interface AirlineRepository extends JpaRepository<Airline, Long>
{
    Airline findAirlineByAirlineCode(String airlineCode);
}
