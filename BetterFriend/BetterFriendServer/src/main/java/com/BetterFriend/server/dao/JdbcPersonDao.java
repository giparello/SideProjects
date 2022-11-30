package com.BetterFriend.server.dao;

import com.BetterFriend.server.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class JdbcPersonDao implements PersonDao {
    //create data access object
    private JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    //get all perople objects
    public List<Person> getAllPeople() {
        List<Person> people = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT friend_id, last_name, first_name, phone_number, city, last_time_called, birthday, life_events\n" +
                "\tFROM public.friend;");
        while (results.next()) {
            people.add(mapToPerson(results));
        }
        return people;
    }

    @Override
    public List<Person> getAllPeopleByFirstName(String firstName) {
        List<Person> people = new ArrayList<>();
        String sql = "SELECT friend_id, last_name, first_name, phone_number, city, last_time_called, birthday, life_events\n" +
                "\tFROM public.friend WHERE first_name = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, firstName);
        while (results.next()) {
            people.add(mapToPerson(results));
        }
        return people;
    }

    @Override
    public List<Person> getAllPeopleByLastName(String lastName) {
        List<Person> people = new ArrayList<>();
        String sql = "SELECT friend_id, last_name, first_name, phone_number, city, last_time_called, birthday, life_events\n" +
                "\tFROM public.friend WHERE first_name = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, lastName);
        while (results.next()) {
            people.add(mapToPerson(results));
        }
        return people;
    }

    public Person addPerson(Person person) {
        Person newPerson = new Person();
        newPerson.setBirthDay(person.getBirthDay());
        newPerson.setLastTimeCalled(person.getLastTimeCalled());
        newPerson.setCity(person.getCity());
        newPerson.setPhoneNumber(person.getPhoneNumber());
        newPerson.setLastName(person.getLastName());
        newPerson.setFirstName(person.getFirstName());
        newPerson.setLifeEvents(person.getLifeEvents());

        String sql = "INSERT INTO public.friend(\n" +
                "\tlast_name, first_name, phone_number, city, last_time_called, birthday, life_events)\n" +
                "\tVALUES (?, ?, ?, ?, ?, ?, ?) RETURNING friend_id;";
        int friend_id = jdbcTemplate.queryForObject(sql, int.class, newPerson.getLastName(), newPerson.getFirstName(), newPerson.getPhoneNumber(), newPerson.getCity(), newPerson.getLastTimeCalled(), newPerson.getBirthDay(), newPerson.getLifeEvents());
        newPerson.setFriendId(friend_id);
        return newPerson;
    }

    public boolean updatePerson(int friendId, Person person) {
        Person newPerson = new Person();
        newPerson.setBirthDay(person.getBirthDay());
        newPerson.setLastTimeCalled(person.getLastTimeCalled());
        newPerson.setCity(person.getCity());
        newPerson.setPhoneNumber(person.getPhoneNumber());
        newPerson.setLastName(person.getLastName());
        newPerson.setFirstName(person.getFirstName());
        newPerson.setLifeEvents(person.getLifeEvents());

        String sql = "UPDATE public.friend\n" +
                "\tSET last_name=?, first_name=?, phone_number=?, city=?, last_time_called=?, birthday=?, life_events=?\n" +
                "\tWHERE friend_id = ?;";
        int numberOfRows = jdbcTemplate.update(sql, newPerson.getLastName(), newPerson.getFirstName(), newPerson.getPhoneNumber(), newPerson.getCity(), newPerson.getLastTimeCalled(), newPerson.getBirthDay(), newPerson.getLifeEvents(), friendId);
        return numberOfRows == 1;
    }
    public void deletePerson(int friendId){
        String sql = "DELETE FROM public.friend\n" +
                "\tWHERE friend_id = ?;";
        jdbcTemplate.update(sql, friendId);
    }


    private Person mapToPerson(SqlRowSet results){
        try {
            Person person = new Person();
            person.setFirstName(results.getString("first_name"));
            person.setLastName(results.getString("last_name"));
            person.setPhoneNumber(results.getInt("phone_number"));
            person.setCity(results.getString("city"));
            person.setFriendId(results.getInt("friend_id"));
            if (results.getDate("last_time_called") != null) {
                person.setLastTimeCalled(results.getDate("last_time_called"));
            }
            if (results.getDate("birthday") !=null) {
                person.setBirthDay(results.getDate("birthday"));
            }
            return person;
        }catch (Exception e){
            System.out.println("error");
            return null;
        }
    }


}

