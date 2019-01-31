package com.carreservationsystemCRD.app;

import org.joda.time.Instant;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CreateReservationTests {

    VehicleInventory inventory = new VehicleInventory();
    Car car = new Car("GJ6","car1license6",5,"suv","volkswagen",2018,80,CarType.COMPACT);

    Instant startDate = new Instant("2019-10-10");
    Instant endDate = new Instant("2019-10-13");


    @BeforeMethod
    public void setup(){
        VehicleReservation reservation1 = new VehicleReservation("GJ1",startDate,endDate);
        VehicleReservation reservation2 = new VehicleReservation("GJ2",startDate,endDate);
        VehicleReservation reservation3 = new VehicleReservation("GJ3",startDate,endDate);
        VehicleReservation reservation4 = new VehicleReservation("GJ4",startDate,endDate);
        VehicleReservation reservation5 = new VehicleReservation("GJ5",startDate,endDate);
        inventory.allReservations.add(reservation1);
        inventory.allReservations.add(reservation2);
        inventory.allReservations.add(reservation3);
        inventory.allReservations.add(reservation4);
        inventory.allReservations.add(reservation5);
    }


    @Test
    public void verifyNoCarsAvailableMSG(){
        String errMessage = "There are no cars available in those days :(";
        Assert.assertEquals(inventory.createNewReservation(new Instant("2019-10-10"),new Instant("2019-10-13")), errMessage);
    }

    @Test
    public void verifyBookingCreated(){
        String successMsg = "Reservation created! Have a safe trip!";
        Assert.assertEquals(inventory.createNewReservation(new Instant("2019-10-1"),new Instant("2019-10-3")), successMsg);
    }

    @Test
    public void verifyBookingAddedToReservations(){
        int size = inventory.allReservations.size();
        inventory.createNewReservation(new Instant("2019-12-1"), new Instant("2019-12-3"));
        //VehicleInventory.printReservations(inventory.allReservations);
        Assert.assertEquals(inventory.allReservations.size(), size+1);
    }

    @Test
    public void verifyBookingAddedToReservationsDaysParameter(){
        int size = inventory.allReservations.size();
        inventory.createNewReservation(new Instant("2019-12-1"), 10);
        //VehicleInventory.printReservations(inventory.allReservations);
        Assert.assertEquals(inventory.allReservations.size(), size+1);
    }

    @Test
    public void verifyReservationDeleted(){
        VehicleReservation reservation = new VehicleReservation("GJ5",new Instant("2019-12-12"),new Instant("2019-12-12"));
        inventory.allReservations.add(reservation);
        Assert.assertTrue(inventory.allReservations.contains(reservation));
        inventory.cancelReservation(reservation);
        Assert.assertFalse(inventory.allReservations.contains(reservation));
    }
}
