package com.carreservationsystemCRD.app;

public class Account {
    private String id;
    private String password;
    private Person person;

    public Account() {
    }

    public Account(String id, String password, Person person) {
        this.id = id;
        this.password = password;
        this.person = person;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public Person getPerson() {
        return person;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
