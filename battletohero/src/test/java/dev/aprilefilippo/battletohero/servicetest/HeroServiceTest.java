package dev.aprilefilippo.battletohero.servicetest;

import dev.aprilefilippo.battletohero.entity.HeroEntity;
import dev.aprilefilippo.battletohero.entity.Race;
import dev.aprilefilippo.battletohero.repository.HeroRepository;
import dev.aprilefilippo.battletohero.service.HeroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class HeroServiceTest {

    @Autowired
    private HeroService heroService;

    @MockBean
    private HeroRepository heroRepository;

    private HeroEntity hero1;
    private HeroEntity hero2;
    private List<HeroEntity> heroList;

    @BeforeEach
    public void setUp() {
        hero1 = new HeroEntity("Hero1", Race.ORC, 10, 5, 100, 1);
        hero2 = new HeroEntity("Hero2", Race.WIZARD, 5, 10, 50, 1);
        heroList = List.of(hero1, hero2);
    }

    @Test
    @Order(1)
    public void testCreateHero() {
        // Quando tu chiami heroRepository.save(hero1) ritornami hero1 a prescindere
        when(heroRepository.save(hero1)).thenReturn(hero1);

        // Chiamo il metodo createHero del heroService con hero1
        HeroEntity createdHero = heroService.createHero(hero1);

        assertEquals(hero1, createdHero);
        assertNotEquals(hero2, createdHero);

        // Verifico che il metodo save del heroRepository sia stato chiamato con hero1 una volta sola
        verify(heroRepository, times(1)).save(hero1);
    }

    @Test
    @Order(2)
    public void testGetAllHeroes() {
        // Quando tu chiami heroRepository.findAll() ritornami heroList a prescindere
        when(heroRepository.findAll()).thenReturn(heroList);

        // Chiamo il metodo getAllHeroes del heroService
        List<HeroEntity> allHeroes = heroService.getAllHeroes();

        assertEquals(heroList.size(), allHeroes.size());
        for (int i = 0; i < heroList.size(); i++) {
            assertEquals(heroList.get(i), allHeroes.get(i));
        }
        // Verifico che il metodo findAll del heroRepository sia stato chiamato una volta sola
        verify(heroRepository, times(1)).findAll();
    }

    @Test
    @Order(3)
    public void testGetHeroById() {
        // Quando tu chiami heroRepository.findById(1) ritornami hero1 a prescindere
        when(heroRepository.findById(1)).thenReturn(Optional.of(hero1));

        // Chiamo il metodo getHeroById del heroService con id 1
        HeroEntity hero = heroService.getHeroById(1);

        assertEquals(hero1, hero);
        assertNotEquals(hero2, hero);

        // Verifico che il metodo findById del heroRepository sia stato chiamato con 1 una volta sola
        verify(heroRepository, times(1)).findById(1);
    }

    @Test
    @Order(4)
    public void testUpdateHero() {
        // Quando tu chiami heroRepository.existsById(1) ritornami true a prescindere
        when(heroRepository.existsById(1)).thenReturn(true);
        // Quando tu chiami heroRepository.save(hero1) ritornami hero1 a prescindere
        when(heroRepository.save(hero1)).thenReturn(hero1);

        // Chiamo il metodo updateHero del heroService con id 1 e hero1
        boolean result = heroService.updateHero(1, hero1);

        // Verifico che il metodo updateHero abbia ritornato true
        assertTrue(result);

        // Verifico che il metodo save del heroRepository sia stato chiamato con hero1 una volta sola
        verify(heroRepository, times(1)).save(hero1);
    }

    @Test
    @Order(5)
    public void testDeleteHero() {
        // Quando tu chiami heroRepository.existsById(1) ritornami true a prescindere
        when(heroRepository.existsById(1)).thenReturn(true);

        // Chiamo il metodo deleteHero del heroService con id 1
        boolean result = heroService.deleteHero(1);

        // Verifico che il metodo deleteHero abbia ritornato true
        assertTrue(result);

        // Verifico che il metodo deleteById del heroRepository sia stato chiamato con 1 una volta sola
        verify(heroRepository, times(1)).deleteById(1);
    }
}
