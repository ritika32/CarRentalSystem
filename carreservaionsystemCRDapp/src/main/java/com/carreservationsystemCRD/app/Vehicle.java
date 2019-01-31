package com.carreservationsystemCRD.app;

public abstract class Vehicle {
    private String vin;
    private String licenseNumber;
    private int passengerCapacity;
    private String model;
    private String make;
    private int manufacturingYear;
    private int mileage;

    Vehicle(String vin, String licenseNumber, int passengerCapacity, String model, String make, int manufacturingYear, int mileage) {
        this.vin = vin;
        this.licenseNumber = licenseNumber;
        this.passengerCapacity = passengerCapacity;
        this.model = model;
        this.make = make;
        this.manufacturingYear = manufacturingYear;
        this.mileage = mileage;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }



    public void setModel(String model) {
        this.model = model;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getVin() {
        return vin;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public int getMileage() {
        return mileage;
    }
}