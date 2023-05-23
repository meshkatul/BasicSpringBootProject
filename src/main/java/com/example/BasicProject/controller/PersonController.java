package com.example.BasicProject.controller;

import com.example.BasicProject.entity.Person;
import com.example.BasicProject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persons")
public class PersonController {
    @Autowired
    PersonService personService;

    //show all person's list
    @GetMapping
    public List<Person> list(){
        return personService.listPersons();
    }

    //add a new person
    @PostMapping
    public Person addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }

    //get a person's information by id
    @GetMapping("/{id}")
    public Person getPerson(@PathVariable int id){
        Person person = personService.getPerson(id);
        return person;
    }

    //delete a person by id
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable int id){
        personService.deletePerson(id);
    }

    //update a person
    @PutMapping("/{id}")
    public Person updatePerson(@RequestBody Person person, @PathVariable int id){
        Person personToUpdate = personService.getPerson(id);

        personToUpdate.setId(person.getId());
        personToUpdate.setFirstName(person.getFirstName());
        personToUpdate.setLastName(person.getLastName());
        personToUpdate.setAge(person.getAge());
        personToUpdate.setGender(person.getGender());
        personToUpdate.setPhoneNumber(person.getPhoneNumber());
        personToUpdate.setAddress(person.getAddress());

        return personService.addPerson(personToUpdate);
    }

}
