package com.carreservationsystemCRD.app;

import org.joda.time.Instant;

import java.util.List;

public interface ChangeInventory {
    public List<Vehicle> addNewVehicle(Vehicle vehicle, Receptionist receptionist);
    public List<Vehicle> removeVehicle(Vehicle vehicle, Receptionist receptionist);
}
