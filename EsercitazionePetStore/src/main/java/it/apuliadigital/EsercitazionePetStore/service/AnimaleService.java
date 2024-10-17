package it.apuliadigital.EsercitazionePetStore.service;

import it.apuliadigital.EsercitazionePetStore.server.model.Pet;

import java.util.List;

public interface AnimaleService {
    List<Pet> listPets(Integer limit);
    Pet getPetById(Long idPet);
    Pet createPet(Pet pet);
    boolean updatePet(Long id, Pet pet);
    boolean deletePet(Long id);
}
