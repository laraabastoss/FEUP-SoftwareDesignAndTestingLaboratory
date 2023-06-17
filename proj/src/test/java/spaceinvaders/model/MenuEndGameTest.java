package spaceinvaders.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spaceinvaders.model.MenuEndGame;
import spaceinvaders.model.MenuWin;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuEndGameTest {

    MenuEndGame menuEndGame;

    @BeforeEach
    public void setUp(){
        menuEndGame = new MenuEndGame();
    }
    @Test
    public void getEntries(){
        menuEndGame.nextEntry();
        assertEquals(true, menuEndGame.isSelectedExit());
        menuEndGame.nextEntry();
        assertEquals(true, menuEndGame.isSelectedBackToMainMenu());
        menuEndGame.previousEntry();
        assertEquals(true,menuEndGame.isSelected(1));
        assertEquals("Exit", menuEndGame.getEntry(1));
        assertEquals(2,menuEndGame.getNumberEntries());

    }
}
