package spaceinvaders.state;

import spaceinvaders.controller.Controller;
import spaceinvaders.controller.MenuController;
import spaceinvaders.controller.MenuWinController;
import spaceinvaders.model.Menu;
import spaceinvaders.model.MenuWin;
import spaceinvaders.view.MenuViewer;
import spaceinvaders.view.MenuWinViewer;
import spaceinvaders.view.Viewer;

public class MenuWinState extends State<MenuWin>{

    public MenuWinState(MenuWin model){
        super(model);
    }
    @Override
    protected Viewer<MenuWin> getViewer() {
        return new MenuWinViewer(getModel());
    }

    @Override
    protected Controller<MenuWin> getController() {
        return new MenuWinController(getModel());
    }
}
