package com.carreservationsystemCRD.app;

import org.joda.time.Instant;

public interface CreateReservation {
    public String createNewReservation(Instant startDate, Instant endDate);
    public String createNewReservation(Instant startDate, int numberOfDays);
    public String cancelReservation(VehicleReservation reservation);
}
