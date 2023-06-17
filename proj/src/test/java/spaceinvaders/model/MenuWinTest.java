package spaceinvaders.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spaceinvaders.Game;
import spaceinvaders.gui.GUI;
import spaceinvaders.model.MenuWin;
import spaceinvaders.state.MenuWinState;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuWinTest {
    MenuWin menuWin;

    @BeforeEach
    public void setUp(){

        menuWin = new MenuWin(2);


    }

    @Test
    public void getEntries(){
        menuWin.nextEntry();
        assertEquals(true, menuWin.isSelectedBacktoMenu());
        menuWin.nextEntry();
        assertEquals(true, menuWin.isSelectedNextLevel());
        menuWin.previousEntry();
        assertEquals(true,menuWin.isSelected(1));
        assertEquals("Back to Main Menu", menuWin.getEntry(1));
        assertEquals(2,menuWin.getNumberEntries());
        assertEquals(2,menuWin.getNext_level());
    }


}
