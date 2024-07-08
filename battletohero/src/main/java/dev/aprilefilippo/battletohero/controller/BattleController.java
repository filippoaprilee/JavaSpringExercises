package dev.aprilefilippo.battletohero.controller;


import dev.aprilefilippo.battletohero.exception.ErrorResponse;
import dev.aprilefilippo.battletohero.exception.HeroException;
import dev.aprilefilippo.battletohero.exception.SuccessResponse;
import dev.aprilefilippo.battletohero.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class BattleController {

    @Autowired
    private BattleService battleService;

    @GetMapping("/battle")
    public SuccessResponse<String> battle(@RequestParam int heroe1, @RequestParam int heroe2, @RequestParam(required = false) String logic) {
        String winner = battleService.simulateBattle(heroe1, heroe2, logic);
        return new SuccessResponse<>(HttpStatus.OK.value(), "Battle completed", winner);
    }

    @ExceptionHandler(value = HeroException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleHeroesNotFound(HeroException e) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
}