package com.carreservationsystemCRD.app;

import org.joda.time.Instant;
import org.joda.time.Interval;
import java.util.ArrayList;
import java.util.List;

public class VehicleInventory implements ChangeInventory, CreateReservation{

    public List<Vehicle> allCars = getListOfCar();
    public List<VehicleReservation> allReservations = getListOfReservation();

    //create a dummy database
    public static List<Vehicle> getListOfCar() {
        List<Vehicle> listOfCar = new ArrayList<>();
        Car car1 = new Car("GJ1","car1license1",5,"suv","volkswagen",2018,80,CarType.COMPACT);
        Car car2 = new Car("GJ2","car1license2",5,"sedan","volkswagen",2017,70,CarType.FULL_SIZE);
        Car car3 = new Car("GJ3","car1license3",2,"suv","volkswagen",2018,80,CarType.STANDARD);
        Car car4 = new Car("GJ4","car1license4",2,"sedan","volkswagen",2018,80,CarType.LUXURY);
        Car car5 = new Car("GJ5","car1license5",4,"suv","volkswagen",2010,60,CarType.ECONOMY);
        listOfCar.add(car1);
        listOfCar.add(car2);
        listOfCar.add(car3);
        listOfCar.add(car4);
        listOfCar.add(car5);
        return listOfCar;
    }


    public static List<VehicleReservation> getListOfReservation(){
        List<VehicleReservation> listOfReservation = new ArrayList<>();
        VehicleReservation reservation1 = new VehicleReservation("GJ1",new Instant("2019-1-1"),new Instant("2019-1-3"));
        VehicleReservation reservation2 = new VehicleReservation("GJ2",new Instant("2019-1-1"),new Instant("2019-1-3"));

        listOfReservation.add(reservation1);
        listOfReservation.add(reservation2);
        return listOfReservation;
    }

    //get all cars in range
    public List<Vehicle> getAllCarsInRange(Instant startDate, Instant endDate){
        List<Vehicle> allAvailable = new ArrayList<Vehicle>(allCars);

        Interval interval1 = new Interval(startDate, endDate);

        for (VehicleReservation allRese : allReservations){
            Interval interval2 = new Interval(allRese.getStartDate(), allRese.getEndDate());
            if(interval1.overlap(interval2) != null){
                allAvailable.remove(getOverLapVehicles(allAvailable, allRese.getVInNumber()));
            }
        }
        return allAvailable;
    }

    //method to get cars in overlapping time range
    private Vehicle getOverLapVehicles(List<Vehicle> vehicles, String vin) {
        for (Vehicle vehicle: vehicles) {
            if (vin.equals(vehicle.getVin())) {
                return vehicle;
            }
        }
        return null;
    }

    //helpers to print Vehicle list
    public static void printListwithVin(List<Vehicle> vehicles){
        for(Vehicle v: vehicles){
            System.out.println(v.getVin());
        }
    }

    //helper to print reservation list
    public static void printReservations(List<VehicleReservation> reservations){
        for (VehicleReservation v : reservations){
            System.out.println(v.getVInNumber());
            System.out.println(v.getStartDate());
            System.out.println(v.getEndDate());
        }
    }

    //add new vehicle to inventory
    @Override
    public List<Vehicle> addNewVehicle(Vehicle vehicle, Receptionist receptionist){
        //check if account type is receptionist then allow adding
        allCars.add(vehicle);
        return allCars;
    }

    //removevehicle from inventory
    @Override
    public List<Vehicle> removeVehicle(Vehicle vehicle, Receptionist receptionist) {
        allCars.remove(vehicle);
        return allCars;
    }

    //get all available cars in the date range
    //add car to reservations table
    @Override
    public String createNewReservation(Instant startDate, Instant endDate){
        if (getAllCarsInRange(startDate,endDate).isEmpty()){
            return "There are no cars available in those days :(";
        }
        else {
            Vehicle vehicle = getAllCarsInRange(startDate, endDate).get(0);
            String vin = vehicle.getVin();
            VehicleReservation reservation = new VehicleReservation(vin, startDate, endDate);

            //suppose the user chooses the first car from the list
            allReservations.add(reservation);
            return "Reservation created! Have a safe trip!";
        }
    }

    //get all available cars in date range
    //add cars to reservation table
    @Override
    public String createNewReservation(Instant startDate, int numberOfDays){
        Instant endDate = startDate.plus(numberOfDays);
        if (getAllCarsInRange(startDate,endDate).isEmpty()){
            return "There are no cars available in those days :(";
        }else {
            Vehicle vehicle = getAllCarsInRange(startDate, endDate).get(0);
            String vin = vehicle.getVin();
            VehicleReservation reservation = new VehicleReservation(vin, startDate, endDate);

            //suppose the user chooses the first car from the list
            allReservations.add(reservation);
            return "Reservation created! Have a safe trip!";
        }
    }

    @Override
    public String cancelReservation(VehicleReservation reservation) {
        if(allReservations.contains(reservation)){
            allReservations.remove(reservation);
            return "Reservation has been deleted";

        }else {
            return "Reservation does not exist.";
        }
    }
}
