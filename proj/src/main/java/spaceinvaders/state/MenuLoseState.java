package spaceinvaders.state;

import spaceinvaders.controller.Controller;
import spaceinvaders.controller.MenuLoseController;
import spaceinvaders.controller.MenuWinController;
import spaceinvaders.model.MenuLose;
import spaceinvaders.model.MenuWin;
import spaceinvaders.view.MenuLoseViewer;
import spaceinvaders.view.MenuWinViewer;
import spaceinvaders.view.Viewer;

public class MenuLoseState extends State<MenuLose>{
    public MenuLoseState(MenuLose menulose){super(menulose);}

    protected Viewer<MenuLose> getViewer() {
        return new MenuLoseViewer(getModel());
    }

    @Override
    protected Controller<MenuLose> getController() {
        return new MenuLoseController(getModel());
    }
}
