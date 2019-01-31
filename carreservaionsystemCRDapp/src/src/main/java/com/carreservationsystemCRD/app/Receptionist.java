package com.carreservationsystemCRD.app;

import org.joda.time.Instant;

import java.util.List;

public class Receptionist extends Account {
    private Instant joinedDate;

    public Receptionist() {

    }

    public Receptionist(String id, String password, Person person, Instant joinedDate) {
        super(id, password, person);
        this.joinedDate = joinedDate;
    }
}
