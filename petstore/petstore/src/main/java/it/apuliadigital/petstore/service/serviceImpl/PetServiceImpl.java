package it.apuliadigital.petstore.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springdoc.core.converters.models.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.apuliadigital.petstore.entity.PetEntity;
import it.apuliadigital.petstore.mapper.PetMapper;
import it.apuliadigital.petstore.model.Pet;
import it.apuliadigital.petstore.repository.PetRepository;
import it.apuliadigital.petstore.service.PetService;

@Service
public class PetServiceImpl implements PetService {
    
    @Autowired
    PetRepository repo;

    @Autowired
    PetMapper mapper;

    @Override
    public void createPets(Pet pet) {
        PetEntity entity = mapper.dtoToEntity(pet);
        repo.save(entity);
    }

    @Override
    public List<Pet> listPets(Integer limit) {        
       Iterable<PetEntity> iterable = repo.findAll();
       List<PetEntity> entityList = new ArrayList<>();
       List<Pet> petList = new ArrayList<>();
       iterable.forEach(entityList::add);
       for (int i = 0; i<limit;i++) {
            PetEntity entity = entityList.get(i);
            Pet pet = mapper.entityToDto(entity);
            petList.add(pet);
       }
        return petList;
    }

    @Override
    public Pet showPetById(String petId) {
        Long idLong = Long.parseLong(petId);
        Optional<PetEntity> opt = repo.findById(idLong);
        PetEntity entity = opt.get();
        Pet pet = mapper.entityToDto(entity);
        return pet;
    }

}
