package com.BetterFriend.server.controller;


import com.BetterFriend.server.dao.PersonDao;
import com.BetterFriend.server.model.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    private PersonDao personDao;

    public PersonController(PersonDao personDao){
        this.personDao = personDao;
    }

    @RequestMapping(path = "friend", method = RequestMethod.GET)
    public List<Person> getAllFriends(){
        return personDao.getAllPeople();
    }

    @RequestMapping(path = "friend", method = RequestMethod.POST)
    public Person addPerson(@RequestBody Person person){
        if (person!= null){
            personDao.addPerson(person);
        }return person;
    }
    @RequestMapping(path = "friend/{friendId}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable int friendId){
        personDao.deletePerson(friendId);
    }
    @RequestMapping(path = "friend/{friendId}", method = RequestMethod.POST)
    public Person updatePerson(@RequestBody Person person){
        personDao.updatePerson(person.getFriendId(), person);
        return person;
    }

}
