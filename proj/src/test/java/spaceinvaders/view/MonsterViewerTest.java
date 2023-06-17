package spaceinvaders.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.gui.GUI;
import spaceinvaders.model.ListMonster;
import spaceinvaders.model.Monster;
import spaceinvaders.model.SpaceShip;
import spaceinvaders.view.MonsterViewer;
import spaceinvaders.view.SpaceShipViewer;

public class MonsterViewerTest {
    private Monster monster= new ListMonster(10,10,10);
    private MonsterViewer monsterViewer= new MonsterViewer();
    private GUI gui;

    @BeforeEach
    void beforeAll() {
        gui = Mockito.mock(GUI.class);
        monster.setChar('6');
        monster.setColor("FFFFFF");
    }

    @Test
    void drawElement() {
        monsterViewer.draw(monster, gui);
        Mockito.verify(gui, Mockito.times(1)).drawMonster(monster.getPosition(),monster.getChar(),monster.getColor());
    }
}
