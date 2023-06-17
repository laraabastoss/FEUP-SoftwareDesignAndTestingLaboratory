package spaceinvaders.controller;

import spaceinvaders.Game;
import spaceinvaders.model.ArenaBuilder;
import spaceinvaders.model.Menu;
import spaceinvaders.model.Settings;
import spaceinvaders.soundeffects.SelectSound;
import spaceinvaders.soundeffects.SoundEffect;
import spaceinvaders.state.GameState;
import spaceinvaders.state.SettingsState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {

    public MenuController(Menu menu){
        super(menu);
    }

    @Override
    public void step(Game game, String key, long time) throws IOException {
        switch (key) {
            case "UP":
                getModel().previousEntry();
                break;

            case "DOWN":
                getModel().nextEntry();
                break;

            case "SELECT":

                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStart()) game.setState(new GameState(new ArenaBuilder(1, 80,30, game.getplaySound()).createArena(game.getplaySound())));
                if (getModel().isSelectedSettings()) game.setState(new SettingsState(new Settings(game.getplayMusic(),game.getplaySound())));
                break;

        }
    }
}
