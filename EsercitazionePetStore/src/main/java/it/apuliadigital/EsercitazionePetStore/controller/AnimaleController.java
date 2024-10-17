package it.apuliadigital.EsercitazionePetStore.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.apuliadigital.EsercitazionePetStore.server.api.ApiUtil;
import it.apuliadigital.EsercitazionePetStore.server.api.PetsApi;
import it.apuliadigital.EsercitazionePetStore.server.model.Pet;
import it.apuliadigital.EsercitazionePetStore.service.AnimaleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnimaleController implements PetsApi {

    @Autowired
    private AnimaleService animaleService;

    Logger logger = LoggerFactory.getLogger(AnimaleController.class);

    public ResponseEntity<Void> createPets(
            @Parameter(name = "Pet", description = "", required = true) @Valid @RequestBody Pet pet
    ) {
        try {
            animaleService.createPet(pet);
            logger.info("Created pet with ID: " + pet.getId());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error creating pet with ID: " + pet.getId(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Pet> deletePet(
            @Parameter(name = "petId", description = "The id of the pet to delete", required = true, in = ParameterIn.PATH) @PathVariable("petId") Long petId
    ) {
        try {
            animaleService.deletePet(petId);
            logger.info("Deleted pet with ID: " + petId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error deleting pet with ID: " + petId, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<List<Pet>> listPets(
            @Max(100) @Parameter(name = "limit", description = "How many items to return at one time (max 100)", in = ParameterIn.QUERY) @Valid @RequestParam(value = "limit", required = false) Integer limit
    ) {
        logger.debug("Fetching all pets");
        List<Pet> pets = animaleService.listPets(limit);
        if (pets.isEmpty()) {
            logger.warn("No pets found");
        }
        return new ResponseEntity<>(pets, HttpStatus.OK);

    }

    public ResponseEntity<Pet> showPetById(
            @Parameter(name = "petId", description = "The id of the pet to retrieve", required = true, in = ParameterIn.PATH) @PathVariable("petId") Long petId
    ) {
        Pet pet = animaleService.getPetById(petId);
        return new ResponseEntity<Pet>(pet, HttpStatus.OK);
    }

    public ResponseEntity<Pet> updatePet(
            @Parameter(name = "petId", description = "The id of the pet to update", required = true, in = ParameterIn.PATH) @PathVariable("petId") Long petId,
            @Parameter(name = "Pet", description = "", required = true) @Valid @RequestBody Pet pet
    ) {
        try {
            animaleService.updatePet(petId, pet);
            logger.info("Updated pet with ID: " + petId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error updating pet with ID: " + petId, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
