package com.example.BasicProject.service;

import com.example.BasicProject.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.example.BasicProject.entity.Person;
import java.util.*;
@Configuration
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    //get all person's list
    public List<Person> listPersons(){
        return personRepository.findAll();
    }

    //add a new person
    public Person addPerson(Person person){
        return personRepository.save(person);
    }

    //get a person by id
    public Person getPerson(int id){
        Person person = personRepository.findById(id).get();
        return person;
    }



    //delete a person by id
    public void deletePerson(int id){
        personRepository.deleteById(id);
    }

}
