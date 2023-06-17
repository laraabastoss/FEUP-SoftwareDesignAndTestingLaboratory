package spaceinvaders.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.gui.LanternaGUI;
import spaceinvaders.model.Position;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GUITest {
    private  Screen screen= Mockito.mock(Screen.class);
    private TextGraphics tg= Mockito.mock(TextGraphics.class);
    private LanternaGUI gui = new LanternaGUI(screen);

    @BeforeEach
    void setUp() {
        Mockito.when(screen.newTextGraphics()).thenReturn(tg);

    }
    @Test
    void drawText() {
        gui.drawText(new Position(1, 1), "Test", "#336699");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "Test");
    }

    @Test
    void drawSpaceship() {
        gui.drawSpaceShip(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(50, 205, 50));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "$");
    }
    @Test
    void drawMonster() {
        gui.drawMonster(new Position(1, 1),'6', "#FFFFFF");


        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "6");
    }

    @Test
    void drawBonusMonster() {
        gui.drawBonusMonster(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 0, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "~");
    }

    @Test
    void drawBlock() {
        gui.drawBlock(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 51, 255));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "#");
    }

    @Test
    void drawBullet() {
        gui.drawBullet(new Position(1, 1), "down");


        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "|");
    }

    @Test
    void Screen() throws IOException {
       gui.clear();
       gui.close();
       gui.refresh();
       Mockito.verify(screen, Mockito.times(1)).clear();
       Mockito.verify(screen, Mockito.times(1)).close();
       Mockito.verify(screen, Mockito.times(1)).refresh();
    }

    @Test
    void Keys() throws IOException{
         assertEquals("NONE",gui.getKey());
    }


}
