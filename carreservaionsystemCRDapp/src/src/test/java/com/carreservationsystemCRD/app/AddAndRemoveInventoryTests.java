package com.carreservationsystemCRD.app;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddAndRemoveInventoryTests {

    Receptionist receptionist = new Receptionist();
    VehicleInventory inventory = new VehicleInventory();
    Member member = new Member();
    Car car = new Car("GJ6","car1license6",5,"suv","volkswagen",2018,80,CarType.COMPACT);

    @Test
    //Test should pass when recptionist adds new car inventory
    public void receptionistAddsInventory(){
        List<Vehicle> updatedList  = inventory.addNewVehicle(car, receptionist);
        //verify added to car inventory list
        Assert.assertTrue(updatedList.contains(car));

        //It does not allow member as the object and does not allow memeber to add new cars to inventory
    }

    @Test
    //Test should pass when recptionist adds new car inventory
    public void receptionistRemovesInventory(){
        List<Vehicle> updatedList  = inventory.removeVehicle(car, receptionist);
        //verify removed to car inventory list
        Assert.assertFalse(updatedList.contains(car));

        //It does not allow member as the object and does not allow memeber to remove cars to inventory
    }
}
