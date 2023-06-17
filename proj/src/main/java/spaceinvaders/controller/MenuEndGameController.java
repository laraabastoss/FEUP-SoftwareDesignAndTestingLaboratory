package spaceinvaders.controller;

import spaceinvaders.Game;
import spaceinvaders.model.ArenaBuilder;
import spaceinvaders.model.Menu;
import spaceinvaders.model.MenuEndGame;
import spaceinvaders.model.MenuWin;
import spaceinvaders.state.GameState;
import spaceinvaders.state.MenuState;

import java.io.IOException;

public class MenuEndGameController extends Controller<MenuEndGame> {
    public MenuEndGameController(MenuEndGame end_menu){super(end_menu);}

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
                if (getModel().isSelectedBackToMainMenu()) game.setState(new MenuState(new Menu()));
                break;
        }
    }
}
