package spaceinvaders.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.gui.GUI;
import spaceinvaders.model.*;
import spaceinvaders.view.*;

import java.io.IOException;

public class MenuViewerTest {
    private Menu menu= new Menu();

    private MenuViewer menuViewer= new MenuViewer(menu);
    private MenuWin menuWin= new MenuWin(1);
    private MenuWinViewer menuWinViewer= new MenuWinViewer(menuWin);
    private MenuLose menuLose= new MenuLose(1);
    private MenuLoseViewer menuLoseViewer= new MenuLoseViewer(menuLose);
    private MenuEndGame menuEndGame= new MenuEndGame();
    private MenuEndGameViewer menuEndGameViewer= new MenuEndGameViewer(menuEndGame);
    private Settings settings=new Settings(true,true);
    private SettingsViewer settingsViewer=new SettingsViewer(settings);
    private GUI gui;

    @BeforeEach
    void beforeAll() {
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElementMenu() throws IOException {
        menuViewer.draw(gui);
        menuWinViewer.draw(gui);
        menuLoseViewer.draw(gui);
        menuEndGameViewer.draw(gui);
        settingsViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(0)).drawSpaceShip(new Position(10,10));
        Mockito.verify(gui, Mockito.times(0)).drawBlock(new Position(10,10));
    }

}
