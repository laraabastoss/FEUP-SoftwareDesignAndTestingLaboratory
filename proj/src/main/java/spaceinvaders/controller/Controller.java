package spaceinvaders.controller;

import spaceinvaders.Game;

import java.io.IOException;

public abstract class Controller<T> {
    private final T model;
    public Controller(T model){
        this.model=model;
    }

    public T getModel() {
        return model;
    }
    public abstract void step(Game game, String key, long time) throws IOException;


}
