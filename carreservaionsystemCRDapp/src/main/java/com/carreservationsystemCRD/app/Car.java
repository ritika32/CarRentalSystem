package com.carreservationsystemCRD.app;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Car")
public class Car extends Vehicle {
    private CarType type;

    public Car(String vin, String licenseNumber, int passengerCapacity, String model, String make, int manufacturingYear, int mileage, CarType type) {
        super(vin, licenseNumber, passengerCapacity, model, make, manufacturingYear, mileage);
        this.type = type;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }
}
