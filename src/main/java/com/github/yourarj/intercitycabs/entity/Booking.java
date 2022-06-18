/* (C)2022 */
package com.github.yourarj.intercitycabs.entity;

import jakarta.persistence.*;

import java.time.Instant;

import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
@ToString
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FK_CabId")
    private Cab cab;

    @ManyToOne
    @JoinColumn(name = "FK_SourceCityId")
    private City source;

    @ManyToOne
    @JoinColumn(name = "FK_DestinationCityId")
    private City destinationCity;

    private Instant rideStart;

    private Instant rideEnd;

    private long rideDuration;

    protected Booking() {
    }

    public Booking(final Cab cab, final City source, final City destinationCity) {
        this.cab = cab;
        this.source = source;
        this.destinationCity = destinationCity;
    }
}
