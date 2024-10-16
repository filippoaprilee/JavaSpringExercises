package it.apuliadigital.esercizio_mongo;

import it.apuliadigital.esercizio_mongo.document.GroceryItemEntity;
import it.apuliadigital.esercizio_mongo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class EsercizioMongoApplication {

//	@Autowired
//	private ItemRepository groveryItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(EsercizioMongoApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		createGroveryItems();
//	}
//
//	private void createGroveryItems() {
//		System.out.println("Data creation started...");
//		groveryItemRepository.save(new GroceryItemEntity("Apple", "Apple", 10, "Fruit"));
//		groveryItemRepository.save(new GroceryItemEntity("Banana","Banana", 20, "Fruit"));
//		groveryItemRepository.save(new GroceryItemEntity("Orange","Orange", 30, "Fruit"));
//		groveryItemRepository.save(new GroceryItemEntity("Tomato","Tomato", 40, "Vegetable"));
//		groveryItemRepository.save(new GroceryItemEntity("Potato","Potato", 50, "Vegetable"));
//		groveryItemRepository.save(new GroceryItemEntity("Onion","Onion", 60, "Vegetable"));
//		System.out.println("Data creation completed...");
//	}

}
