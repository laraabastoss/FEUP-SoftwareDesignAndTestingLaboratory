package spaceinvaders.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spaceinvaders.model.Menu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuTest {
    Menu menu;

    @BeforeEach
    public void setUp(){
        menu = new Menu();
    }

    @Test
    public void getEntries(){
        menu.nextEntry();
        assertTrue(menu.isSelectedSettings());
        menu.nextEntry();
        assertTrue(menu.isSelectedExit());
        menu.nextEntry();
        assertTrue(menu.isSelectedStart());
        menu.previousEntry();
        assertTrue(menu.isSelected(2));
        assertEquals("Settings", menu.getEntry(1));
        assertEquals(3,menu.getNumberEntries());
    }
}
