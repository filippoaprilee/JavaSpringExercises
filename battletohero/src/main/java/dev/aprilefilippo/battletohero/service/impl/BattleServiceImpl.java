package dev.aprilefilippo.battletohero.service.impl;

import dev.aprilefilippo.battletohero.entity.BattleEntity;
import dev.aprilefilippo.battletohero.entity.HeroEntity;
import dev.aprilefilippo.battletohero.exception.HeroException;
import dev.aprilefilippo.battletohero.repository.BattleRepository;
import dev.aprilefilippo.battletohero.repository.HeroRepository;
import dev.aprilefilippo.battletohero.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BattleServiceImpl implements BattleService {

    @Autowired
    private BattleRepository battleRepository;

    @Autowired
    private HeroRepository heroRepository;

    @Override
    public String simulateBattle(int hero1Id, int hero2Id, String logic) {
        HeroEntity hero1 = heroRepository.findById(hero1Id)
                .orElseThrow(() -> new HeroException("Hero with ID " + hero1Id + " not found"));
        HeroEntity hero2 = heroRepository.findById(hero2Id)
                .orElseThrow(() -> new HeroException("Hero with ID " + hero2Id + " not found"));

        int hero1Score = calculateScore(hero1, logic);
        int hero2Score = calculateScore(hero2, logic);

        String winner = determineWinner(hero1, hero2, hero1Score, hero2Score, logic);
        BattleEntity battle = new BattleEntity(hero1Id, hero2Id, winner);
        battleRepository.save(battle);
        return winner;
    }

    private int calculateScore(HeroEntity hero, String logic) {
        return switch (logic.toLowerCase()) {
            case "strength" -> hero.getStrength();
            case "defense" -> hero.getDefense();
            case "health" -> hero.getHealth();
            case "level" -> hero.getLevel();
            default -> hero.getStrength() + hero.getDefense() + hero.getHealth() + hero.getLevel();
        };
    }

    private String determineWinner(HeroEntity hero1, HeroEntity hero2, int hero1Score, int hero2Score, String logic) {
        String capitalizedLogic = logic.substring(0, 1).toUpperCase() + logic.substring(1).toLowerCase();
        String battleResult = "Battle between " + hero1.getName() + " and " + hero2.getName() + " using " + capitalizedLogic + " logic";
        if (hero1Score > hero2Score) {
            battleResult += ". Winner: " + hero1.getName();
        } else if (hero2Score > hero1Score) {
            battleResult += ". Winner: " + hero2.getName();
        } else {
            battleResult += ". Result: Tie";
        }
        return battleResult;
    }
}
