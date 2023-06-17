package spaceinvaders.contoller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.Game;
import spaceinvaders.controller.MenuEndGameController;
import spaceinvaders.controller.MenuLoseController;
import spaceinvaders.model.MenuEndGame;
import spaceinvaders.model.MenuLose;

import java.io.IOException;

public class MenuEndGameControllerTest {
    MenuEndGameController menuEndGameController;
    MenuEndGame menuEndGame;
    Game game;

    @BeforeEach
    void setUp(){
        menuEndGame = Mockito.mock(MenuEndGame.class);
        game = Mockito.mock(Game.class);
        menuEndGameController = new MenuEndGameController(menuEndGame);
    }
    @Test
    public void stepUp() throws IOException {
        menuEndGameController.step(game, "UP", 1000);

        Mockito.verify(menuEndGameController.getModel(), Mockito.times(1)).previousEntry();
        Mockito.verify(menuEndGameController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuEndGameController.getModel(), Mockito.times(0)).isSelectedBackToMainMenu();
        Mockito.verify(menuEndGameController.getModel(), Mockito.times(0)).isSelectedExit();
        Mockito.verify(game, Mockito.times(0)).setState(null);
    }

    @Test
    public void stepDown() throws IOException {
        menuEndGameController.step(game, "DOWN", 1000);

        Mockito.verify(menuEndGameController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuEndGameController.getModel(), Mockito.times(1)).nextEntry();
        Mockito.verify(menuEndGameController.getModel(), Mockito.times(0)).isSelectedExit();
        Mockito.verify(menuEndGameController.getModel(), Mockito.times(0)).isSelectedBackToMainMenu();
        Mockito.verify(game, Mockito.times(0)).setState(null);
    }
    @Test
    public void stepSelectBacktoMainMenu() throws IOException {

        Mockito.when(menuEndGameController.getModel().isSelectedBackToMainMenu()).thenReturn(true);

        menuEndGameController.step(game, "SELECT", 1000);

        Mockito.verify(menuEndGameController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuEndGameController.getModel(), Mockito.times(1)).isSelectedBackToMainMenu();
        Mockito.verify(menuEndGameController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(game, Mockito.times(0)).setState(null);
    }

    @Test
    public void stepSelectExit() throws IOException {
        Mockito.when(menuEndGameController.getModel().isSelectedExit()).thenReturn(true);
        menuEndGameController.step(game, "SELECT", 1000);


        Mockito.verify(menuEndGameController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuEndGameController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuEndGameController.getModel(), Mockito.times(1)).isSelectedBackToMainMenu();
        Mockito.verify(menuEndGameController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(game, Mockito.times(1)).setState(null);
    }

}
