package spaceinvaders.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spaceinvaders.model.MenuLose;
import spaceinvaders.model.MenuWin;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuLoseTest {
    MenuLose menuLose;

    @BeforeEach
    public void setUp(){
        menuLose = new MenuLose(2);
    }

    @Test
    public void getEntries(){
        menuLose.nextEntry();
        assertEquals(true, menuLose.isSelectedBacktoMenu());
        menuLose.nextEntry();
        assertEquals(true, menuLose.isSelectedPlayAgain());
        menuLose.previousEntry();
        assertEquals(true,menuLose.isSelected(1));
        assertEquals("Back to Main Menu", menuLose.getEntry(1));
        assertEquals(2,menuLose.getNumberEntries());
        assertEquals(2,menuLose.getCurr_level());
    }
}
