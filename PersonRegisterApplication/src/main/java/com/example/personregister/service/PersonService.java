package com.example.personregister.service;

import com.example.personregister.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPersons();
    Person getPersonById(Long id);
    Person savePerson(Person person);
    void deletePerson(Long id);
}
