package spaceinvaders.state;

import spaceinvaders.Game;
import spaceinvaders.controller.Controller;
import spaceinvaders.gui.GUI;
import spaceinvaders.view.Viewer;

import java.io.IOException;

public abstract class State<T> {
    private final T model;
    private final Viewer<T> viewer;
    private final Controller<T> controller;

    public State(T model){
        this.model=model;
        this.viewer=getViewer();
        this.controller=getController();
    }
    protected abstract Viewer<T> getViewer();
    protected abstract Controller<T> getController();
    public T getModel() {
        return model;
    }
    public void step(Game game, GUI gui, long time) throws IOException {
        String key = gui.getKey();
        controller.step(game, key, time);
        viewer.draw(gui);
    }
}
