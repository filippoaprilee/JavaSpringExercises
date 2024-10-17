package it.apuliadigital.EsercitazionePetStore.service.impl;

import it.apuliadigital.EsercitazionePetStore.entity.AnimaleEntity;
import it.apuliadigital.EsercitazionePetStore.mapper.AnimaleMapper;
import it.apuliadigital.EsercitazionePetStore.repository.AnimaleRepository;
import it.apuliadigital.EsercitazionePetStore.server.model.Pet;
import it.apuliadigital.EsercitazionePetStore.service.AnimaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnimaleServiceImpl implements AnimaleService {

    @Autowired
    private AnimaleRepository animaleRepository;

    @Autowired
    private AnimaleMapper animaleMapper;


    @Override
    public List<Pet> listPets(Integer limit) {
        Optional<Integer> limitOptional = Optional.ofNullable(limit);
        return Streamable.of(animaleRepository.findAll()).stream()
                .map(pet -> animaleMapper.toDto(pet))
                .limit(limitOptional.orElse(100))
                .toList();
    }

    @Override
    public Pet getPetById(Long idPet) {
        Optional<AnimaleEntity> entity = animaleRepository.findById(idPet);
        return entity.map(animaleMapper::toDto).orElse(null);
    }

    @Override
    public Pet createPet(Pet pet) {
        AnimaleEntity entity = animaleMapper.toEntity(pet);
        animaleRepository.save(entity);
        pet.setId(entity.getId());
        return pet;
    }

    @Override
    public boolean updatePet(Long id, Pet pet) {
        if (animaleRepository.existsById(id)) {
            AnimaleEntity entity = animaleMapper.toEntity(pet);
            entity.setId(id);
            animaleRepository.save(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePet(Long id) {
        if (animaleRepository.existsById(id)) {
            animaleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
