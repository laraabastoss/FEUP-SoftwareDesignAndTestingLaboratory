package spaceinvaders.states;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.Game;
import spaceinvaders.gui.GUI;
import spaceinvaders.model.*;
import spaceinvaders.state.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameStateTest {
    GameState gameState;
    Game game;
    GUI gui;

    @BeforeEach
    void setUp(){
        game = Mockito.mock(Game.class);
        gameState = Mockito.mock(GameState.class);
        gui=Mockito.mock(GUI.class);
    }
    @Test
    public void loseGame() throws IOException {

        MenuLoseState ml=new MenuLoseState(new MenuLose(1));
        game.setState(ml);
        assertEquals(null, game.getState());
    }

    @Test
    public void winGame() throws IOException{

        MenuWinState mw=new MenuWinState(new MenuWin(1));
        game.setState(mw);
        assertEquals(null, game.getState());
    }

    @Test
    public void endGame() throws IOException {

        MenuEndGameState meg=new MenuEndGameState(new MenuEndGame());
        game.setState(meg);
        assertEquals(null, game.getState());
    }
}
