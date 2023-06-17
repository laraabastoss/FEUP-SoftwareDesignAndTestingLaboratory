package spaceinvaders.contoller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.Game;
import spaceinvaders.controller.MenuLoseController;
import spaceinvaders.model.Menu;
import spaceinvaders.model.MenuLose;
import spaceinvaders.state.MenuState;

import java.io.IOException;

public class MenuLoseControllerTest {
    MenuLoseController menuLoseController;
    MenuLose menuLose;
    Game game;

    @BeforeEach
    void setUp(){
        menuLose = Mockito.mock(MenuLose.class);
        game = Mockito.mock(Game.class);
        menuLoseController = new MenuLoseController(menuLose);
    }
    @Test
    public void stepUp() throws IOException {
        menuLoseController.step(game, "UP", 1000);

        Mockito.verify(menuLoseController.getModel(), Mockito.times(1)).previousEntry();
        Mockito.verify(menuLoseController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuLoseController.getModel(), Mockito.times(0)).isSelectedBacktoMenu();
        Mockito.verify(menuLoseController.getModel(), Mockito.times(0)).isSelectedPlayAgain();
    }

    @Test
    public void stepDown() throws IOException {
        menuLoseController.step(game, "DOWN", 1000);

        Mockito.verify(menuLoseController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuLoseController.getModel(), Mockito.times(1)).nextEntry();
        Mockito.verify(menuLoseController.getModel(), Mockito.times(0)).isSelectedBacktoMenu();
        Mockito.verify(menuLoseController.getModel(), Mockito.times(0)).isSelectedPlayAgain();
    }
    @Test
    public void stepSelectPlayAgain() throws IOException {

        Mockito.when(menuLoseController.getModel().isSelectedPlayAgain()).thenReturn(true);

        menuLoseController.step(game, "SELECT", 1000);

        Mockito.verify(menuLoseController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuLoseController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuLoseController.getModel(), Mockito.times(1)).isSelectedPlayAgain();
        Mockito.verify(menuLoseController.getModel(), Mockito.times(1)).isSelectedBacktoMenu();
    }

    @Test
    public void stepSelectBackToMenu() throws IOException {

        Mockito.when(menuLoseController.getModel().isSelectedBacktoMenu()).thenReturn(true);

        menuLoseController.step(game, "SELECT", 1000);

        Mockito.verify(menuLoseController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuLoseController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuLoseController.getModel(), Mockito.times(1)).isSelectedPlayAgain();
        Mockito.verify(menuLoseController.getModel(), Mockito.times(1)).isSelectedBacktoMenu();
    }


}
