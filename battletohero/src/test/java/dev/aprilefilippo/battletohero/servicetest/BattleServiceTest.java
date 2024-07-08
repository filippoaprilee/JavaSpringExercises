package dev.aprilefilippo.battletohero.servicetest;

import dev.aprilefilippo.battletohero.entity.BattleEntity;
import dev.aprilefilippo.battletohero.entity.HeroEntity;
import dev.aprilefilippo.battletohero.entity.Race;
import dev.aprilefilippo.battletohero.repository.BattleRepository;
import dev.aprilefilippo.battletohero.repository.HeroRepository;
import dev.aprilefilippo.battletohero.service.BattleService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BattleServiceTest {

    @Autowired
    private BattleService battleService;

    @MockBean
    private BattleRepository battleRepository;

    @MockBean
    private HeroRepository heroRepository;

    @Test
    public void testSimulateBattle_StrengthLogic() {
        // Crea due eroi con attributi identici per testare il parametro di forza
        HeroEntity hero1 = new HeroEntity("Hero1", Race.ORC, 10, 5, 100, 1);
        HeroEntity hero2 = new HeroEntity("Hero2", Race.WIZARD, 8, 5, 50, 1);
        // Configura il comportamento dei mock per restituire gli eroi creati quando viene chiamato il metodo findById
        when(heroRepository.findById(1)).thenReturn(Optional.of(hero1));
        when(heroRepository.findById(2)).thenReturn(Optional.of(hero2));
        // Esegue il metodo da testare e salva il risultato
        String result = battleService.simulateBattle(1, 2, "strength");
        // Verifica che il risultato indichi il vincitore e il punteggio
        assertEquals("Battle between Hero1 and Hero2 using Strength logic. Winner: Hero1", result);
        verify(battleRepository).save(new BattleEntity(1, 2, result));
    }

    @Test
    public void testSimulateBattle_DefenseLogic() {
        // Crea due eroi con attributi identici per testare il parametro di difesa
        HeroEntity hero1 = new HeroEntity("Hero1", Race.ORC, 5, 10, 100, 1);
        HeroEntity hero2 = new HeroEntity("Hero2", Race.WIZARD, 5, 8, 50, 1);
        // Configura il comportamento dei mock per restituire gli eroi creati quando viene chiamato il metodo findById
        when(heroRepository.findById(1)).thenReturn(Optional.of(hero1));
        when(heroRepository.findById(2)).thenReturn(Optional.of(hero2));
        // Esegue il metodo da testare e salva il risultato
        String result = battleService.simulateBattle(1, 2, "defense");
        // Verifica che il risultato indichi il vincitore e il punteggio
        assertEquals("Battle between Hero1 and Hero2 using Defense logic. Winner: Hero1", result);
        verify(battleRepository).save(new BattleEntity(1, 2, result));
    }

    @Test
    public void testSimulateBattle_HealthLogic() {
        // Crea due eroi con attributi identici per testare il parametro di salute
        HeroEntity hero1 = new HeroEntity("Hero1", Race.ORC, 5, 5, 150, 1);
        HeroEntity hero2 = new HeroEntity("Hero2", Race.WIZARD, 5, 5, 100, 1);
        // Configura il comportamento dei mock per restituire gli eroi creati quando viene chiamato il metodo findById
        when(heroRepository.findById(1)).thenReturn(Optional.of(hero1));
        when(heroRepository.findById(2)).thenReturn(Optional.of(hero2));
        // Esegue il metodo da testare e salva il risultato
        String result = battleService.simulateBattle(1, 2, "health");
        // Verifica che il risultato indichi il vincitore e il punteggio
        assertEquals("Battle between Hero1 and Hero2 using Health logic. Winner: Hero1", result);
        verify(battleRepository).save(new BattleEntity(1, 2, result));
    }

    @Test
    public void testSimulateBattle_LevelLogic() {
        // Crea due eroi con attributi identici per testare il parametro di livello
        HeroEntity hero1 = new HeroEntity("Hero1", Race.ORC, 5, 5, 100, 2);
        HeroEntity hero2 = new HeroEntity("Hero2", Race.WIZARD, 5, 5, 100, 1);
        // Configura il comportamento dei mock per restituire gli eroi creati quando viene chiamato il metodo findById
        when(heroRepository.findById(1)).thenReturn(Optional.of(hero1));
        when(heroRepository.findById(2)).thenReturn(Optional.of(hero2));
        // Esegue il metodo da testare e salva il risultato
        String result = battleService.simulateBattle(1, 2, "level");
        // Verifica che il risultato indichi il vincitore e il punteggio
        assertEquals("Battle between Hero1 and Hero2 using Level logic. Winner: Hero1", result);
        verify(battleRepository).save(new BattleEntity(1, 2, result));
    }


    @Test
    public void testSimulateBattle_TieResult() {
        // Crea due eroi con attributi identici per testare il risultato di parità
        HeroEntity hero1 = new HeroEntity("Hero1", Race.ORC, 10, 10, 100, 1);
        HeroEntity hero2 = new HeroEntity("Hero2", Race.WIZARD, 10, 10, 100, 1);
        // Configura il comportamento dei mock per restituire gli eroi creati quando viene chiamato il metodo findById
        when(heroRepository.findById(5)).thenReturn(Optional.of(hero1));
        when(heroRepository.findById(6)).thenReturn(Optional.of(hero2));
        // Esegue il metodo da testare e salva il risultato
        String result = battleService.simulateBattle(5, 6, "strength");
        // Verifica che il risultato indichi un pareggio
        assertEquals("Battle between Hero1 and Hero2 using Strength logic. Result: Tie", result);
        verify(battleRepository).save(new BattleEntity(5, 6, result));
    }

}

