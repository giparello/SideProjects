package com.BetterFriend.server.model;

import java.util.Date;

public class Person {
    int friendId;
    String lastName;
    String firstName;
    int phoneNumber;
    String city;
    Date lastTimeCalled;
    Date birthDay;
    String lifeEvents;

    public Person(){

    };

    public Person(int friendId, String lastName, String firstName, int phoneNumber, String city,Date lastTimeCalled, Date birthDay, String lifeEvents){
        this.friendId = friendId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.lastTimeCalled = lastTimeCalled;
        this.birthDay = birthDay;
        this.lifeEvents = lifeEvents;
    }

    public String getLifeEvents() {
        return lifeEvents;
    }

    public void setLifeEvents(String lifeEvents) {
        this.lifeEvents = lifeEvents;
    }

    public String getCity() {
        return city;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getFriendId() {
        return friendId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public Date getLastTimeCalled() {
        return lastTimeCalled;
    }


    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public void setLastTimeCalled(Date lastTimeCalled) {
        this.lastTimeCalled = lastTimeCalled;
    }


}

