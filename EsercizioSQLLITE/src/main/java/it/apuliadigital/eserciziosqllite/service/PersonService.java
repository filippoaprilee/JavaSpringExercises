package it.apuliadigital.eserciziosqllite.service;

import it.apuliadigital.eserciziosqllite.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPersons();
    Person getPersonById(Long id);
    Person createPerson(Person person);
    Person updatePerson(Long id, Person person);
    void deletePerson(Long id);
}
