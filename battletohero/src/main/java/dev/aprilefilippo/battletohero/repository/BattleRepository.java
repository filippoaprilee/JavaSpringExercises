package dev.aprilefilippo.battletohero.repository;

import dev.aprilefilippo.battletohero.entity.BattleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BattleRepository extends JpaRepository<BattleEntity, Integer> {

}
