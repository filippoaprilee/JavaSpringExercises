package dev.aprilefilippo.battletohero.service.impl;

import dev.aprilefilippo.battletohero.entity.HeroEntity;
import dev.aprilefilippo.battletohero.repository.HeroRepository;
import dev.aprilefilippo.battletohero.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    private HeroRepository heroRepository;

    @Override
    public HeroEntity createHero(HeroEntity hero) {
        return heroRepository.save(hero);
    }

    @Override
    public List<HeroEntity> getAllHeroes() {
        return (List<HeroEntity>) heroRepository.findAll();

    }

    @Override
    public HeroEntity getHeroById(int id) {
        return heroRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateHero(int id, HeroEntity heroEntity) {
        if (heroRepository.existsById(id)) {
            heroEntity.setId(id);
            heroRepository.save(heroEntity);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteHero(int id) {
        if (heroRepository.existsById(id)) {
            heroRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
