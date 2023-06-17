package spaceinvaders.controller;

import spaceinvaders.Game;
import spaceinvaders.model.Arena;
import spaceinvaders.model.ArenaBuilder;
import spaceinvaders.model.Position;
import spaceinvaders.soundeffects.AttackSound;
import spaceinvaders.soundeffects.GameSound;
import spaceinvaders.soundeffects.SoundEffect;
import spaceinvaders.state.GameState;

import java.io.IOException;

public abstract class GameController extends Controller<Arena> {

    public GameController(Arena arena) {
        super(arena);
    }

}
