package spaceinvaders.controller;

import spaceinvaders.Game;
import spaceinvaders.model.ArenaBuilder;
import spaceinvaders.model.Menu;
import spaceinvaders.model.MenuLose;
import spaceinvaders.model.MenuWin;
import spaceinvaders.state.GameState;
import spaceinvaders.state.MenuState;

import java.io.IOException;

public class MenuLoseController extends Controller<MenuLose>{
    public MenuLoseController(MenuLose menulose){super(menulose);}

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
                if (getModel().isSelectedPlayAgain()) game.setState(new GameState(new ArenaBuilder(getModel().getCurr_level(), 80,30,game.getplaySound()).createArena(game.getplaySound())));
                break;
        }
    }
}
