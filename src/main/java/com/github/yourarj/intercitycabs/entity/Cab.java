package com.github.yourarj.intercitycabs.entity;

import com.github.yourarj.intercitycabs.util.CabState;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Entity
@Getter
@ToString
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String externalId;

    @Setter
    @ManyToOne
    @JoinColumn(name ="FK_CityId")
    private City cityId;

    @ManyToOne
    @JoinColumn(name ="FK_OwnerId")
    private User ownerId;

    @Setter
    @Enumerated(EnumType.STRING)
    private CabState state = CabState.IDLE;

    @Getter
    private Instant currentRideStart;

    protected Cab() {
    }

    public Cab(final String cabId, final CabState state, final City city) {
        this.externalId = cabId;
        this.state = state;
        this.cityId = city;
    }
}
