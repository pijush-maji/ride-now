package com.ridenow.app.model;

import com.ridenow.app.constant.RideStatus;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

public class Rides {
    private Long ridesId;
    @ManyToOne()
    private Long driverId;
    private Long riderId;
    private String pickupLoc;
    private String destination;
    private RideStatus status;
    private Double fare;
    private String requestAt;
    private String completedAt;
}
