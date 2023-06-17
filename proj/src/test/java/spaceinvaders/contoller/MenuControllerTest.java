package spaceinvaders.contoller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.Game;
import spaceinvaders.controller.MenuController;
import spaceinvaders.gui.GUI;
import spaceinvaders.gui.LanternaGUI;
import spaceinvaders.model.Arena;
import spaceinvaders.model.Menu;
import spaceinvaders.model.Settings;
import spaceinvaders.state.GameState;
import spaceinvaders.state.MenuState;
import spaceinvaders.state.SettingsState;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuControllerTest {
    MenuController menuController;
    Menu menu;
    Game game;

    @BeforeEach
    void setUp(){
        menu = Mockito.mock(Menu.class);
        game = Mockito.mock(Game.class);
        menuController = new MenuController(menu);
    }

    @Test
    public void stepUp() throws IOException {
        menuController.step(game, "UP", 1000);

        Mockito.verify(menuController.getModel(), Mockito.times(1)).previousEntry();
        Mockito.verify(menuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuController.getModel(), Mockito.times(0)).isSelectedExit();
        Mockito.verify(menuController.getModel(), Mockito.times(0)).isSelectedSettings();
        Mockito.verify(menuController.getModel(), Mockito.times(0)).isSelectedStart();
        Mockito.verify(game, Mockito.times(0)).setState(null);
    }

    @Test
    public void stepDown() throws IOException {
        menuController.step(game, "DOWN", 1000);

        Mockito.verify(menuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuController.getModel(), Mockito.times(1)).nextEntry();
        Mockito.verify(menuController.getModel(), Mockito.times(0)).isSelectedExit();
        Mockito.verify(menuController.getModel(), Mockito.times(0)).isSelectedSettings();
        Mockito.verify(menuController.getModel(), Mockito.times(0)).isSelectedStart();
        Mockito.verify(game, Mockito.times(0)).setState(null);
    }

    @Test
    public void stepSelectStart() throws IOException {

        Mockito.when(menuController.getModel().isSelectedStart()).thenReturn(true);
        menuController.step(game, "SELECT", 1000);

        Mockito.verify(menuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(menuController.getModel(), Mockito.times(1)).isSelectedSettings();
        Mockito.verify(menuController.getModel(), Mockito.times(1)).isSelectedStart();
        Mockito.verify(game, Mockito.times(0)).setState(null);
    }

    @Test
    public void stepSelectSettings() throws IOException {

        Mockito.when(menuController.getModel().isSelectedSettings()).thenReturn(true);
        menuController.step(game, "SELECT", 1000);

        Mockito.verify(menuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(menuController.getModel(), Mockito.times(1)).isSelectedSettings();
        Mockito.verify(menuController.getModel(), Mockito.times(1)).isSelectedStart();
        Mockito.verify(game, Mockito.times(0)).setState(null);
    }

    @Test
    public void stepSelectExit() throws IOException {

        Mockito.when(menuController.getModel().isSelectedExit()).thenReturn(true);
        menuController.step(game, "SELECT", 1000);

        Mockito.verify(menuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(menuController.getModel(), Mockito.times(1)).isSelectedSettings();
        Mockito.verify(menuController.getModel(), Mockito.times(1)).isSelectedStart();
        Mockito.verify(game, Mockito.times(1)).setState(null);
    }

    @Test
    public void selectGame() throws IOException{
        menuController.step(game, "SELECT", 1000);
        GameState g=new GameState(new Arena(100,30,1,false));
        game.setState(g);

        assertEquals(null, game.getState());
    }

    @Test
    public void selectSettings() throws IOException{
        menuController.step(game, "DOWN", 1000);
        menuController.step(game, "SELECT", 1000);
        SettingsState s=new SettingsState(new Settings(false, false));
        game.setState(s);
        assertEquals(null, game.getState());
    }
}
