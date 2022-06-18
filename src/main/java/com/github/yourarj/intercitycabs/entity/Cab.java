/* (C)2022 */
package com.github.yourarj.intercitycabs.entity;

import com.github.yourarj.intercitycabs.util.CabState;
import jakarta.persistence.*;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@ToString
public class Cab {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@Setter
@ManyToOne
@JoinColumn(name = "FK_CityId")
private City city;

@ManyToOne
@JoinColumn(name = "FK_OwnerId")
private User owner;

@Setter
@Enumerated(EnumType.STRING)
private CabState state = CabState.IDLE;

@Getter private Instant currentRideStart;

protected Cab() {}

public Cab(final CabState state, final City city) {
	this.state = state;
	this.city = city;
}
}
