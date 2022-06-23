package com.example.AirwayPlanningAPI.repository.flight;

import com.example.AirwayPlanningAPI.entity.Flight;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by MHAKTANACAR on 19.06.2022
 */
@Repository
@Transactional
public class CustomFlightRepositoryImpl implements CustomFlightRepository
{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Flight> findTodaysFlight()
    {
        Query query = entityManager.createNativeQuery("SELECT * FROM flight as fl " +
                "WHERE fl.FLIGHT_DATE = CURRENT_DATE  ", Flight.class);
        return query.getResultList();
    }

    @Override
    public List<Flight> getFlightByAirlineId(long airlineId)
    {
        Query query = entityManager.createNativeQuery("SELECT * FROM flight as fl " +
                "WHERE fl.AIRLINE_ID = :airlineId  ", Flight.class);
        query.setParameter("airlineId", airlineId);
        return query.getResultList();
    }

    @Override
    public List<Flight> getFlightByAirportId(long airportId)
    {
        Query query = entityManager.createNativeQuery("SELECT * FROM flight as fl " +
                "WHERE fl.SOURCE_AIRPORT_ID = :airportId " +
                "OR fl.DEST_AIRPORT_ID = :airportId", Flight.class);
        query.setParameter("airportId", airportId);
        return query.getResultList();
    }

    @Override
    public List<Flight> getFlightsByDate(Date date)
    {
        Query query = entityManager.createNativeQuery("SELECT * FROM flight as fl " +
                "WHERE fl.FLIGHT_DATE = :date  ", Flight.class);
        query.setParameter("date", date);
        return query.getResultList();
    }

    @Override
    public List<Flight> checkThatDaysFlightCount(Date date, long sourceAirportId, long destAirportId, long airlineId)
    {
        Query query = entityManager.createNativeQuery("SELECT * FROM flight as fl " +
                "WHERE fl.FLIGHT_DATE = :date  " +
                "AND ((SOURCE_AIRPORT_ID = :sourceAirportId OR DEST_AIRPORT_ID = :sourceAirportId) AND (SOURCE_AIRPORT_ID = :destAirportId OR DEST_AIRPORT_ID = :destAirportId))" +
                "AND AIRLINE_ID = :airlineId", Flight.class);
        query.setParameter("date", date);
        query.setParameter("sourceAirportId", sourceAirportId);
        query.setParameter("destAirportId", destAirportId);
        query.setParameter("airlineId", airlineId);
        return query.getResultList();
    }
}
