package it.apuliadigital.petstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import it.apuliadigital.petstore.api.PetsApi;
import it.apuliadigital.petstore.model.Pet;
import it.apuliadigital.petstore.service.PetService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;

@RestController
public class PetController implements PetsApi {

    @Autowired
    PetService service;


    @Override
    public ResponseEntity<Void> createPets(
            @Parameter(name = "Pet", description = "", required = true) @Valid @RequestBody Pet pet) {
                service.createPets(pet);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<List<Pet>> listPets(
            @Max(100) @Parameter(name = "limit", description = "How many items to return at one time (max 100)", in = ParameterIn.QUERY) @Valid @RequestParam(value = "limit", required = false) Integer limit) {
               List<Pet> listaPet = service.listPets(limit);
        return new ResponseEntity<List<Pet>>(listaPet,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Pet> showPetById(
            @Parameter(name = "petId", description = "The id of the pet to retrieve", required = true, in = ParameterIn.PATH) @PathVariable("petId") String petId) {
             Pet pet =  service.showPetById(petId);
        return new ResponseEntity<Pet>(pet,HttpStatus.OK);

    }
}
