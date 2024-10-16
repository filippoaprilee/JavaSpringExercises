package it.apuliadigital.esercizio_mongo.service;

import it.apuliadigital.esercizio_mongo.model.GroceryItemDTO;

import java.util.List;

public interface MongoService {
        GroceryItemDTO createGroceryItem(GroceryItemDTO groceryItemDTO);
        GroceryItemDTO getGroceryItemById(String id);
        List<GroceryItemDTO> getAllGroceryItems();
        boolean updateGroceryItem(String id, GroceryItemDTO groceryItemDTO);
        boolean deleteGroceryItem(String id);
        GroceryItemDTO findItemByName(String name); // Nuovo metodo
        List<GroceryItemDTO> findAllByCategory(String category); // Nuovo metodo
        long count(); // Metodo per contare gli articoli
}