package com.carreservationsystemCRD.app;

import org.joda.time.Instant;

public class Member extends Account  {

    private String driverLicenseNum;

    public Member() {
    }

    public Member(String id, String password, Person person, String driverLicenseNum) {
        super(id, password, person);
        this.driverLicenseNum = driverLicenseNum;
    }
}
