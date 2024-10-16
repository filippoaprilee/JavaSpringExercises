package it.apuliadigital.esercizio_mongo.repository;

import it.apuliadigital.esercizio_mongo.document.GroceryItemEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ItemRepository extends MongoRepository<GroceryItemEntity, String> {

    @Query("{name:'?0'}")
    GroceryItemEntity findItemByName(String name);

    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1, 'category' : 1}")
    List<GroceryItemEntity> findAll(String category);

    public long count();
}
