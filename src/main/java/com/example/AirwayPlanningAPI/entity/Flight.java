package com.example.AirwayPlanningAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by MHAKTANACAR on 19.06.2022
 */
@Entity
@Table(name = "flight")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Flight
{
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    private String id;

    @Column(name = "FLIGHT_NUMBER")
    private String flightNumber;

    @DateTimeFormat(pattern = "yyy-MM-dd-HH.mm.ss")
    @Column(name = "FLIGHT_DATE")
    private Date flightDate;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "AIRLINE_ID")
    private Airline airline;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "SOURCE_AIRPORT_ID")
    private Airport sourceAirport;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "DEST_AIRPORT_ID")
    private Airport destAirport;
}
