package it.apuliadigital.esercizio_mongo.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.apuliadigital.esercizio_mongo.api.ApiUtil;
import it.apuliadigital.esercizio_mongo.api.GroceryItemsApi;
import it.apuliadigital.esercizio_mongo.document.GroceryItemEntity;
import it.apuliadigital.esercizio_mongo.model.GroceryItemDTO;
import it.apuliadigital.esercizio_mongo.service.MongoService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MongoController implements GroceryItemsApi {

    @Autowired
    private MongoService mongoService;

    Logger logger = LoggerFactory.getLogger(MongoController.class);


    public ResponseEntity<GroceryItemDTO> createGroceryItem(
            @Parameter(name = "GroceryItemDTO", description = "Data for the new grocery item", required = true) @Valid @RequestBody GroceryItemDTO groceryItemDTO
    ) {
        GroceryItemDTO item = mongoService.createGroceryItem(groceryItemDTO);
        logger.info("Grocery item created: " + item);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    public ResponseEntity<GroceryItemDTO> getGroceryItemById(
            @Parameter(name = "itemId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("itemId") String itemId
    ) {
        GroceryItemDTO item = mongoService.getGroceryItemById(itemId);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    public ResponseEntity<GroceryItemDTO> deleteGroceryItem(
            @Parameter(name = "itemId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("itemId") String itemId
    ) {
        boolean deleted = mongoService.deleteGroceryItem(itemId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<GroceryItemDTO>> getAllGroceryItems(

    ) {
        List<GroceryItemDTO> items = mongoService.getAllGroceryItems();
        return new ResponseEntity<>(items, HttpStatus.OK);

    }

    public ResponseEntity<GroceryItemDTO> updateGroceryItem(
            @Parameter(name = "itemId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("itemId") String itemId,
            @Parameter(name = "GroceryItemDTO", description = "Updated grocery item data", required = true) @Valid @RequestBody GroceryItemDTO groceryItemDTO
    ) {
        boolean updated = mongoService.updateGroceryItem(itemId, groceryItemDTO);
        if (updated) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<GroceryItemDTO> getGroceryItemByName(
            @Parameter(name = "name", description = "Name of the grocery item", required = true) @PathVariable("name") String name
    ) {
        GroceryItemDTO item = mongoService.findItemByName(name);
        if (item != null) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Nuovo metodo per ottenere tutti gli articoli di una categoria
    public ResponseEntity<List<GroceryItemDTO>> getAllItemsByCategory(
            @Parameter(name = "category", description = "Category of grocery items", required = true) @PathVariable("category") String category
    ) {
        List<GroceryItemDTO> items = mongoService.findAllByCategory(category);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    // Nuovo metodo per contare gli articoli
    public ResponseEntity<Integer> countGroceryItems() {
        long count = mongoService.count();
        return new ResponseEntity<>((int) count, HttpStatus.OK);
    }

}
