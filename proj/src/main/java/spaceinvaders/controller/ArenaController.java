package spaceinvaders.controller;

import spaceinvaders.Game;
import spaceinvaders.model.*;
import spaceinvaders.soundeffects.AttackSound;
import spaceinvaders.soundeffects.GameSound;
import spaceinvaders.soundeffects.SoundEffect;
import spaceinvaders.state.GameState;
import spaceinvaders.state.MenuEndGameState;
import spaceinvaders.state.MenuLoseState;
import spaceinvaders.state.MenuWinState;

import java.io.IOException;

public class ArenaController extends GameController {


    protected static String currdir="right";
    protected static String currdirbonus="right";
    protected static boolean down=false;

    private final SpaceshipController spaceshipController;
    private final MonsterController monsterController;


    public ArenaController(Arena arena) {
        super(arena);
        this.spaceshipController = new SpaceshipController(arena);
        this.monsterController = new MonsterController(arena);
    }

    @Override
    public void step(Game game, String key, long time) throws IOException {

        if (LoseGame()) game.setState(new MenuLoseState(new MenuLose(getModel().getLevel())));
        if (NextLevel()) game.setState(new MenuWinState(new MenuWin(getModel().getLevel() + 1)));
        if (GameEnd()) game.setState(new MenuEndGameState(new MenuEndGame()));

        if (key == "QUIT") game.setState(null);


        spaceshipController.step(game,key,time);
        monsterController.step(game,key,time);

    }

    public boolean LoseGame(){
        if (getModel().getSpaceship().getLifes() == 0) return true;
        for (Monster monster : getModel().getMonsters()){
            if (getModel().isSpaceship(monster.getPosition()) || monster.getY() > getModel().getSpaceship().getY()) {
                return true;
            }
        }
        return false;
    }

    public boolean NextLevel(){
         if (getModel().getMonsters().size() == 0 && getModel().getLevel() + 1 != 4) return true;
         return false;
    }

    public boolean GameEnd(){
        if (getModel().getMonsters().size() == 0 && getModel().getLevel() + 1 == 4) return true;
        return false;
    }

    public String getCurrdir() {
        return currdir;
    }

    public String getCurrdirbonus() {
        return currdirbonus;
    }
}


