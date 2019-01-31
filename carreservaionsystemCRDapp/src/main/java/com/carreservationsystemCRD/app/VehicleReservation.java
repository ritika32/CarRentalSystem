package com.carreservationsystemCRD.app;

import org.joda.time.Instant;

import java.util.List;

public class VehicleReservation {
    private String vin;
    private Instant startDate;
    private Instant endDate;

    public VehicleReservation(String vin, Instant startDate, Instant endDate) {
        this.vin = vin;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getVInNumber() {
        return vin;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }
}
