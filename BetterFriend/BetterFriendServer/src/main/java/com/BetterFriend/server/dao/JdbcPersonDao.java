package com.BetterFriend.server.dao;

import com.BetterFriend.server.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JdbcPersonDao implements PersonDao{
    //create data access object
    private JdbcTemplate jdbcTemplate;
    public JdbcPersonDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    //get all perople objects
    public List<Person> getAllPeople(){
        List<Person> people = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT friend_id, user_id, last_name, first_name, phone_number, city, last_time_called, birthday, life_events\n" +
                "\tFROM public.friend;");
        while (results.next()){
            people.add(mapToPerson(results));
        }return people;
    }
    /*
   List<Person> getAllPeopleByFirstName(String firstName){}

    List<Person> getAllPeopleByLastName(String lastName);

    void addPerson(String firstName, String lastName, int phoneNumber, String city, Date lastTimeCalled, Date birthDate);

    void updatePerson(String firstName, String lastName, int phoneNumber, String city, Date lastTimeCalled, Date birthDate);

    void deletePerson(int PersonId);
*/
    private Person mapToPerson(SqlRowSet results){
        try {
            Person person = new Person();
            person.setFirstName(results.getString("first_name"));
            person.setLastName(results.getString("last_name"));
            person.setPhoneNumber(results.getInt("phone_number"));
            person.setCity(results.getString("city"));
            person.setFriendId(results.getInt("friend_id"));
            person.setUserId(results.getInt("user_id"));
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

