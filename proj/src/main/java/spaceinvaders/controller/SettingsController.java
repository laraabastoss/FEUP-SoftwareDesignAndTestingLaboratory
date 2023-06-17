package spaceinvaders.controller;

import spaceinvaders.Game;
import spaceinvaders.model.ArenaBuilder;
import spaceinvaders.model.Menu;
import spaceinvaders.model.Settings;
import spaceinvaders.state.GameState;
import spaceinvaders.state.MenuState;
import spaceinvaders.state.SettingsState;

import java.io.IOException;

public class SettingsController extends Controller<Settings> {
    public SettingsController(Settings model) {
        super(model);
    }

    @Override
    public void step(Game game, String key, long time) throws IOException {
        switch(key) {
            case "UP":
                getModel().previousEntry();
                break;

            case "DOWN":
                getModel().nextEntry();
                break;

            case "SELECT":
                if (getModel().isSelectedBacktoMenu()) game.setState(new MenuState(new Menu()));
                break;

            case "RIGHT", "LEFT":
                if (getModel().isSelectedMusic()){
                    game.setplayMusic();
                    getModel().setMuteMusic();
                }
                else if (getModel().isSelectedSound()) {
                    game.setplaySound();
                    getModel().setMuteSound();
                }
                break;

        }
    }
}
