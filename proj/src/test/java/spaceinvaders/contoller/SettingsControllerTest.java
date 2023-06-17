package spaceinvaders.contoller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.Game;
import spaceinvaders.controller.SettingsController;
import spaceinvaders.model.Menu;
import spaceinvaders.model.Settings;
import spaceinvaders.state.MenuState;

import java.io.IOException;

public class SettingsControllerTest {

    SettingsController settingsController;
    Settings settings;
    Game game;

    @BeforeEach
    void setUp(){
        settings = Mockito.mock(Settings.class);
        game = Mockito.mock(Game.class);
        settingsController = new SettingsController(settings);
    }

    @Test
    public void stepUp() throws IOException {

        settingsController.step(game, "UP", 1000);

        Mockito.verify(settingsController.getModel(), Mockito.times(1)).previousEntry();
        Mockito.verify(settingsController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(settingsController.getModel(), Mockito.times(0)).isSelectedBacktoMenu();
        Mockito.verify(settingsController.getModel(), Mockito.times(0)).isSelectedMusic();
        Mockito.verify(settingsController.getModel(), Mockito.times(0)).isSelectedSound();
        Mockito.verify(settingsController.getModel(), Mockito.times(0)).setMuteMusic();
        Mockito.verify(settingsController.getModel(), Mockito.times(0)).setMuteSound();
        Mockito.verify(game, Mockito.times(0)).setplayMusic();
        Mockito.verify(game, Mockito.times(0)).setplaySound();
        
    }

    @Test
    public void stepDown() throws IOException {

        settingsController.step(game, "DOWN", 1000);

        Mockito.verify(settingsController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(settingsController.getModel(), Mockito.times(1)).nextEntry();
        Mockito.verify(settingsController.getModel(), Mockito.times(0)).isSelectedBacktoMenu();
        Mockito.verify(settingsController.getModel(), Mockito.times(0)).isSelectedMusic();
        Mockito.verify(settingsController.getModel(), Mockito.times(0)).isSelectedSound();
        Mockito.verify(settingsController.getModel(), Mockito.times(0)).setMuteMusic();
        Mockito.verify(settingsController.getModel(), Mockito.times(0)).setMuteSound();
        Mockito.verify(game, Mockito.times(0)).setplayMusic();
        Mockito.verify(game, Mockito.times(0)).setplaySound();

    }

    @Test
    public void stepSelect() throws IOException {

        settingsController.step(game, "SELECT", 1000);

        Mockito.verify(settingsController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(settingsController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(settingsController.getModel(), Mockito.times(1)).isSelectedBacktoMenu();
        Mockito.verify(settingsController.getModel(), Mockito.times(0)).isSelectedMusic();
        Mockito.verify(settingsController.getModel(), Mockito.times(0)).isSelectedSound();
        Mockito.verify(settingsController.getModel(), Mockito.times(0)).setMuteMusic();
        Mockito.verify(settingsController.getModel(), Mockito.times(0)).setMuteSound();
        Mockito.verify(game, Mockito.times(0)).setplayMusic();
        Mockito.verify(game, Mockito.times(0)).setplaySound();

    }

    @Test
    public void stepRightMusic() throws IOException {

        Mockito.when(settingsController.getModel().isSelectedMusic()).thenReturn(true);
        settingsController.step(game, "RIGHT", 1000);

        Mockito.verify(settingsController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(settingsController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(settingsController.getModel(), Mockito.times(0)).isSelectedBacktoMenu();
        Mockito.verify(settingsController.getModel(), Mockito.times(1)).isSelectedMusic();
        Mockito.verify(settingsController.getModel(), Mockito.times(0)).isSelectedSound();
        Mockito.verify(settingsController.getModel(), Mockito.times(1)).setMuteMusic();
        Mockito.verify(settingsController.getModel(), Mockito.times(0)).setMuteSound();
        Mockito.verify(game, Mockito.times(1)).setplayMusic();
        Mockito.verify(game, Mockito.times(0)).setplaySound();
    }

    @Test
    public void stepRightSound() throws IOException {

        Mockito.when(settingsController.getModel().isSelectedSound()).thenReturn(true);
        settingsController.step(game, "RIGHT", 1000);

        Mockito.verify(settingsController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(settingsController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(settingsController.getModel(), Mockito.times(0)).isSelectedBacktoMenu();
        Mockito.verify(settingsController.getModel(), Mockito.times(1)).isSelectedMusic();
        Mockito.verify(settingsController.getModel(), Mockito.times(1)).isSelectedSound();
        Mockito.verify(settingsController.getModel(), Mockito.times(0)).setMuteMusic();
        Mockito.verify(settingsController.getModel(), Mockito.times(1)).setMuteSound();
        Mockito.verify(game, Mockito.times(0)).setplayMusic();
        Mockito.verify(game, Mockito.times(1)).setplaySound();
    }

}
