package spaceinvaders.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.gui.GUI;
import spaceinvaders.model.BonusMonster;
import spaceinvaders.model.ListMonster;
import spaceinvaders.model.Monster;
import spaceinvaders.view.BonusMonsterViewer;
import spaceinvaders.view.MonsterViewer;

public class BonusMonsterViewerTest {
    private Monster monster= new BonusMonster(10,10, 30);
    private BonusMonsterViewer monsterViewer= new BonusMonsterViewer();
    private GUI gui;

    @BeforeEach
    void beforeAll() {
        gui = Mockito.mock(GUI.class);
        monster.setChar('~');
        monster.setColor("FFFFFF");
    }

    @Test
    void drawElement() {
        monsterViewer.draw(monster, gui);
        Mockito.verify(gui, Mockito.times(1)).drawBonusMonster(monster.getPosition());
    }
}
