package spaceinvaders.state;

import spaceinvaders.controller.Controller;
import spaceinvaders.controller.MenuController;
import spaceinvaders.controller.MenuEndGameController;
import spaceinvaders.model.Menu;
import spaceinvaders.model.MenuEndGame;
import spaceinvaders.view.MenuEndGameViewer;
import spaceinvaders.view.MenuViewer;
import spaceinvaders.view.Viewer;

public class MenuEndGameState extends State<MenuEndGame>{

    public MenuEndGameState(MenuEndGame end_menu){
        super(end_menu);
    }

    @Override
    protected Viewer<MenuEndGame> getViewer() {
        return new MenuEndGameViewer(getModel());
    }

    @Override
    protected Controller<MenuEndGame> getController() {
        return new MenuEndGameController(getModel());
    }
}
