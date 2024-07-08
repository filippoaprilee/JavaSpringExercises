package dev.aprilefilippo.battletohero.service;

import dev.aprilefilippo.battletohero.entity.HeroEntity;

import java.util.List;

public interface HeroService {
    HeroEntity createHero(HeroEntity heroEntity);
    List<HeroEntity> getAllHeroes();
    HeroEntity getHeroById(int id);
    boolean updateHero(int id, HeroEntity heroEntity);
    boolean deleteHero(int id);
}
