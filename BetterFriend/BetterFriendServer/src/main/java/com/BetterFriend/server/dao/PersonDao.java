package com.BetterFriend.server.dao;

import com.BetterFriend.server.model.Person;

import java.util.Date;
import java.util.List;

public interface PersonDao {

    /*
    int friendId;
    int userId;
    String lastName;
    String firstName;
    int phoneNumber;
    String city;
    Date lastTimeCalled;
    Date birthDay;*/

    List<Person> getAllPeople();

    List<Person> getAllPeopleByFirstName(String firstName);

    List<Person> getAllPeopleByLastName(String lastName);

    Person addPerson(Person person);

    boolean updatePerson(int friendId, Person person);

    void deletePerson(int friendId);
}
