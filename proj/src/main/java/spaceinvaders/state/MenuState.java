package spaceinvaders.state;

import spaceinvaders.controller.Controller;
import spaceinvaders.controller.MenuController;
import spaceinvaders.model.Menu;
import spaceinvaders.view.MenuViewer;
import spaceinvaders.view.Viewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model){
        super(model);
    }
    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }


}
