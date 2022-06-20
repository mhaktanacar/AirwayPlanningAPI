package com.example.AirwayPlanningAPI.repository;

import com.example.AirwayPlanningAPI.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by MHAKTANACAR on 19.06.2022
 */
@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>, CustomFlightRepository
{
}
