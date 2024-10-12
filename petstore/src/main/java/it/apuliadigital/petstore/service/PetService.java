package it.apuliadigital.petstore.service;

import java.util.List;

import it.apuliadigital.petstore.model.Pet;

public interface PetService {

    public void createPets(Pet pet);

    public List<Pet> listPets(Integer limit);

    public Pet showPetById(String petId);

}
