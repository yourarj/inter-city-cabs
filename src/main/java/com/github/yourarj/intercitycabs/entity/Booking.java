package com.github.yourarj.intercitycabs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

@Entity
@Getter
@ToString
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="FK_CabId")
    private Cab cabId;

    @ManyToOne
    @JoinColumn(name ="FK_SourceCityId")
    private City source;

    @ManyToOne
    @JoinColumn(name ="FK_DestinationCityId")
    private City destination;

    private Instant rideStart;

    private Instant rideEnd;

    private long rideDuration;

    protected Booking() {
    }

    public Booking(final Cab cab, final City source, final City destination) {
        this.cabId = cab;
        this.source = source;
        this.destination = destination;
    }
}
