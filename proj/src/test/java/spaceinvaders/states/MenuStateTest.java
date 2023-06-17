package spaceinvaders.states;

import com.googlecode.lanterna.screen.Screen;
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

public class MenuStateTest {
    MenuState menuState;
    Game game;
    GUI gui;

    @BeforeEach
    void setUp(){
        game = Mockito.mock(Game.class);
        menuState = Mockito.mock(MenuState.class);
        gui=Mockito.mock(GUI.class);
    }
    @Test
    public void selectGame() throws IOException {
        GameState g=new GameState(new Arena(100,30,1,false));
        game.setState(g);
        assertEquals(null, game.getState());
    }

    @Test
    public void selectSettings() throws IOException{
        menuState.step(game, gui,1000);
        SettingsState s=new SettingsState(new Settings(true, true));
        game.setState(s);
        assertEquals(null, game.getState());
    }



}
