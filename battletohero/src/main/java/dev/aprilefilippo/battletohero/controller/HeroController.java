package dev.aprilefilippo.battletohero.controller;

import dev.aprilefilippo.battletohero.entity.HeroEntity;
import dev.aprilefilippo.battletohero.exception.ErrorResponse;
import dev.aprilefilippo.battletohero.exception.HeroException;
import dev.aprilefilippo.battletohero.exception.SuccessResponse;
import dev.aprilefilippo.battletohero.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heroes")
public class HeroController {

    @Autowired
    private HeroService heroService;

    @PostMapping
    public SuccessResponse<HeroEntity> createHero(@RequestBody HeroEntity heroEntity) {
        heroService.createHero(heroEntity);
        return new SuccessResponse<>(HttpStatus.CREATED.value(), "Hero created successfully", heroEntity);
    }

    @GetMapping
    public SuccessResponse<List<HeroEntity>> getAllHeroes() {
        List<HeroEntity> heroes = heroService.getAllHeroes();
        return new SuccessResponse<>(HttpStatus.OK.value(), "Heroes retrieved successfully", heroes);
    }

    @GetMapping("/{id}")
    public SuccessResponse<HeroEntity> getHeroById(@PathVariable int id) {
        HeroEntity hero = heroService.getHeroById(id);
        return new SuccessResponse<>(HttpStatus.OK.value(), "Hero retrieved successfully", hero);
    }

    @PutMapping("/{id}")
    public SuccessResponse<Boolean> updateHero(@PathVariable int id, @RequestBody HeroEntity heroEntity) {
        boolean updated = heroService.updateHero(id, heroEntity);
        if (updated) {
            return new SuccessResponse<>(HttpStatus.OK.value(), "Hero updated successfully", true);
        }
        return new SuccessResponse<>(HttpStatus.NOT_FOUND.value(), "Hero not found", false);
    }

    @DeleteMapping("/{id}")
    public SuccessResponse<Boolean> deleteHero(@PathVariable int id) {
        boolean deleted = heroService.deleteHero(id);
        if (deleted) {
            return new SuccessResponse<>(HttpStatus.OK.value(), "Hero deleted successfully", true);
        }
        return new SuccessResponse<>(HttpStatus.NOT_FOUND.value(), "Hero not found", false);
    }

    @ExceptionHandler(value = HeroException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleHeroesNotFound(HeroException e) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
}
