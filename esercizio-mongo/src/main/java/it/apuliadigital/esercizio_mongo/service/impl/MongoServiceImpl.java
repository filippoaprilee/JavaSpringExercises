package it.apuliadigital.esercizio_mongo.service.impl;

import it.apuliadigital.esercizio_mongo.document.GroceryItemEntity;
import it.apuliadigital.esercizio_mongo.mapper.GroceryItemMapper;
import it.apuliadigital.esercizio_mongo.model.GroceryItemDTO;
import it.apuliadigital.esercizio_mongo.repository.ItemRepository;
import it.apuliadigital.esercizio_mongo.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MongoServiceImpl implements MongoService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private GroceryItemMapper groceryItemMapper; // Autowire del mapper

    @Override
    public GroceryItemDTO createGroceryItem(GroceryItemDTO groceryItemDTO) {
        GroceryItemEntity entity = groceryItemMapper.dtoToEntity(groceryItemDTO);
        entity = itemRepository.save(entity);
        return groceryItemMapper.entityToDto(entity);
    }

    @Override
    public GroceryItemDTO getGroceryItemById(String id) {
        Optional<GroceryItemEntity> entityOptional = itemRepository.findById(id);
        return entityOptional.map(groceryItemMapper::entityToDto).orElse(null);
    }

    @Override
    public List<GroceryItemDTO> getAllGroceryItems() {
        return itemRepository.findAll().stream()
                .map(groceryItemMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean updateGroceryItem(String id, GroceryItemDTO groceryItemDTO) {
        if (!itemRepository.existsById(id)) {
            return false; // Indica che l'ID non esiste
        }

        GroceryItemEntity entity = groceryItemMapper.dtoToEntity(groceryItemDTO);
        entity.setId(id); // Assicurati di impostare l'ID dell'entità
        itemRepository.save(entity);
        return true; // Operazione completata con successo
    }

    @Override
    public boolean deleteGroceryItem(String id) {
        if (!itemRepository.existsById(id)) {
            return false; // Indica che l'ID non esiste
        }

        itemRepository.deleteById(id);
        return true; // Operazione completata con successo
    }

    @Override
    public GroceryItemDTO findItemByName(String name) {
        GroceryItemEntity entity = itemRepository.findItemByName(name);
        return groceryItemMapper.entityToDto(entity);
    }

    @Override
    public List<GroceryItemDTO> findAllByCategory(String category) {
        List<GroceryItemEntity> entities = itemRepository.findAll(category);
        return entities.stream()
                .map(groceryItemMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return itemRepository.count();
    }

}
