package spaceinvaders.contoller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.Game;
import spaceinvaders.controller.MenuController;
import spaceinvaders.controller.MenuWinController;
import spaceinvaders.model.Menu;
import spaceinvaders.model.MenuWin;

import java.io.IOException;

public class MenuWinControllerTest {
    MenuWinController menuWinController;
    MenuWin menuWin;
    Game game;

    @BeforeEach
    void setUp(){
        menuWin = Mockito.mock(MenuWin.class);
        game = Mockito.mock(Game.class);
        menuWinController = new MenuWinController(menuWin);
    }
    @Test
    public void stepUp() throws IOException {
        menuWinController.step(game, "UP", 1000);

        Mockito.verify(menuWinController.getModel(), Mockito.times(1)).previousEntry();
        Mockito.verify(menuWinController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuWinController.getModel(), Mockito.times(0)).isSelectedBacktoMenu();
        Mockito.verify(menuWinController.getModel(), Mockito.times(0)).isSelectedNextLevel();
        Mockito.verify(game, Mockito.times(0)).setState(null);
    }

    @Test
    public void stepDown() throws IOException {
        menuWinController.step(game, "DOWN", 1000);

        Mockito.verify(menuWinController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuWinController.getModel(), Mockito.times(1)).nextEntry();
        Mockito.verify(menuWinController.getModel(), Mockito.times(0)).isSelectedBacktoMenu();
        Mockito.verify(menuWinController.getModel(), Mockito.times(0)).isSelectedNextLevel();
        Mockito.verify(game, Mockito.times(0)).setState(null);
    }
    @Test
    public void stepSelectNextLevel() throws IOException {

        Mockito.when(menuWinController.getModel().isSelectedNextLevel()).thenReturn(true);

        menuWinController.step(game, "SELECT", 1000);

        Mockito.verify(menuWinController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuWinController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuWinController.getModel(), Mockito.times(1)).isSelectedNextLevel();
        Mockito.verify(menuWinController.getModel(), Mockito.times(1)).isSelectedBacktoMenu();
        Mockito.verify(game, Mockito.times(0)).setState(null);
    }

    @Test
    public void stepSelectBackToMenu() throws IOException {

        Mockito.when(menuWinController.getModel().isSelectedBacktoMenu()).thenReturn(true);

        menuWinController.step(game, "SELECT", 1000);

        Mockito.verify(menuWinController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuWinController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuWinController.getModel(), Mockito.times(1)).isSelectedNextLevel();
        Mockito.verify(menuWinController.getModel(), Mockito.times(1)).isSelectedBacktoMenu();
        Mockito.verify(game, Mockito.times(0)).setState(null);
    }


}
