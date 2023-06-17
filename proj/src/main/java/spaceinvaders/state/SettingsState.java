package spaceinvaders.state;

import spaceinvaders.controller.Controller;
import spaceinvaders.controller.SettingsController;
import spaceinvaders.model.Menu;
import spaceinvaders.model.Settings;
import spaceinvaders.view.SettingsViewer;
import spaceinvaders.view.Viewer;

public class SettingsState extends State<Settings>{
    public SettingsState(Settings model){super(model);}
    @Override
    protected Viewer<Settings> getViewer() {
        return new SettingsViewer(getModel());
    }

    @Override
    protected Controller<Settings> getController() {
        return new SettingsController(getModel());
    }
}
