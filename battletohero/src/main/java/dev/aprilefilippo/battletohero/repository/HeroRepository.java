package dev.aprilefilippo.battletohero.repository;

import dev.aprilefilippo.battletohero.entity.HeroEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends CrudRepository<HeroEntity, Integer> {
}
