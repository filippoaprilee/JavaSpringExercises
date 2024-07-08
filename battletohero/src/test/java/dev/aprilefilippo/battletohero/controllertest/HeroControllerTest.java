package dev.aprilefilippo.battletohero.controllertest;

import dev.aprilefilippo.battletohero.controller.HeroController;
import dev.aprilefilippo.battletohero.entity.HeroEntity;
import dev.aprilefilippo.battletohero.exception.ErrorResponse;
import dev.aprilefilippo.battletohero.exception.HeroException;
import dev.aprilefilippo.battletohero.exception.SuccessResponse;
import dev.aprilefilippo.battletohero.service.HeroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class HeroControllerTest {

    @MockBean
    private HeroService heroService;

    @Autowired
    private HeroController heroController;

    @Test
    void testCreateHero() {
        HeroEntity heroEntity = new HeroEntity();
        heroEntity.setId(1);
        heroEntity.setName("Test Hero");

        when(heroService.createHero(heroEntity)).thenReturn(heroEntity);

        SuccessResponse<HeroEntity> response = heroController.createHero(heroEntity);

        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
        assertEquals("Hero created successfully", response.getMessage());
        assertEquals(heroEntity, response.getObject());

        verify(heroService).createHero(heroEntity);
    }

    @Test
    void testGetAllHeroes() {
        List<HeroEntity> heroes = List.of(new HeroEntity());
        when(heroService.getAllHeroes()).thenReturn(heroes);

        SuccessResponse<List<HeroEntity>> response = heroController.getAllHeroes();

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals("Heroes retrieved successfully", response.getMessage());
        assertEquals(heroes, response.getObject());

        verify(heroService).getAllHeroes();
    }

    @Test
    void testGetHeroById() {
        HeroEntity hero = new HeroEntity();
        hero.setId(1);
        when(heroService.getHeroById(1)).thenReturn(hero);

        SuccessResponse<HeroEntity> response = heroController.getHeroById(1);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals("Hero retrieved successfully", response.getMessage());
        assertEquals(hero, response.getObject());

        verify(heroService).getHeroById(1);
    }

    @Test
    void testUpdateHero() {
        HeroEntity heroEntity = new HeroEntity();
        heroEntity.setId(1);
        when(heroService.updateHero(1, heroEntity)).thenReturn(true);

        SuccessResponse<Boolean> response = heroController.updateHero(1, heroEntity);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals("Hero updated successfully", response.getMessage());
        assertEquals(true, response.getObject());

        verify(heroService).updateHero(1, heroEntity);
    }

    @Test
    void testDeleteHero() {
        when(heroService.deleteHero(1)).thenReturn(true);

        SuccessResponse<Boolean> response = heroController.deleteHero(1);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals("Hero deleted successfully", response.getMessage());
        assertEquals(true, response.getObject());

        verify(heroService).deleteHero(1);
    }

    @Test
    void testHandleHeroesNotFound() {
        HeroException exception = new HeroException("Hero not found");

        ErrorResponse errorResponse = heroController.handleHeroesNotFound(exception);

        assertEquals(HttpStatus.NOT_FOUND.value(), errorResponse.getStatusCode());
        assertEquals("Hero not found", errorResponse.getMessage());
    }

}