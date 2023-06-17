package spaceinvaders.controller;

import spaceinvaders.Game;
import spaceinvaders.model.ArenaBuilder;
import spaceinvaders.model.Menu;
import spaceinvaders.model.MenuWin;
import spaceinvaders.state.GameState;
import spaceinvaders.state.MenuState;

import java.io.IOException;

public class MenuWinController extends Controller<MenuWin>{

    public MenuWinController(MenuWin menuwin){super(menuwin);}

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
                if (getModel().isSelectedBacktoMenu()) game.setState(new MenuState(new Menu()));
                if (getModel().isSelectedNextLevel()) game.setState(new GameState(new ArenaBuilder(getModel().getNext_level(), 80,30,game.getplaySound()).createArena(game.getplaySound())));
                break;
        }
    }
}
