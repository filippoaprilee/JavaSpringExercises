package dev.aprilefilippo.battletohero.controllertest;

import dev.aprilefilippo.battletohero.controller.BattleController;
import dev.aprilefilippo.battletohero.controller.HeroController;
import dev.aprilefilippo.battletohero.exception.ErrorResponse;
import dev.aprilefilippo.battletohero.exception.HeroException;
import dev.aprilefilippo.battletohero.exception.SuccessResponse;
import dev.aprilefilippo.battletohero.service.BattleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringBootTest
public class BattleControllerTest {

    @MockBean
    private BattleService battleService;

    @Autowired
    private BattleController battleController;
    @Autowired
    private HeroController heroController;

    @Test
    public void testBattle_Success() {
        when(battleService.simulateBattle(1, 2, "strength")).thenReturn("Hero1");

        SuccessResponse<String> response = battleController.battle(1, 2, "strength");

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals("Battle completed", response.getMessage());
        assertEquals("Hero1", response.getObject());

        verify(battleService, times(1)).simulateBattle(1, 2, "strength");
    }

    @Test
    public void testHandleHeroesException() {
        // Given
        HeroException exception = new HeroException("Hero not found");
        when(battleService.simulateBattle(1, 2, "strength")).thenThrow(exception);

        // When
        ErrorResponse errorResponse = null;
        try {
            battleController.battle(1, 2, "strength");
        } catch (HeroException e) {
            errorResponse = battleController.handleHeroesNotFound(e);
        }

        // Then
        assertNotNull(errorResponse);
        assertEquals(HttpStatus.NOT_FOUND.value(), errorResponse.getStatusCode());
        assertEquals("Hero not found", errorResponse.getMessage());
    }
}
