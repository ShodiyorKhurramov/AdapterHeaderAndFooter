package com.example.adapterheaderandfooter.Model;

public class Member {
    private String firstName;
    private  String lastName;
    private Boolean available=false;

    public Member(String firstName, String lastName, Boolean available) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.available = available;
    }
    public Boolean isAvailable() {
        return available;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
