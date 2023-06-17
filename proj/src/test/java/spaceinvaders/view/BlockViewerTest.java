package spaceinvaders.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.gui.GUI;
import spaceinvaders.model.Block;
import spaceinvaders.model.ListMonster;
import spaceinvaders.model.Monster;
import spaceinvaders.view.BlockViewer;
import spaceinvaders.view.MonsterViewer;

public class BlockViewerTest {
    private Block block= new Block(10,10);
    private BlockViewer blockViewer= new BlockViewer();
    private GUI gui;

    @BeforeEach
    void beforeAll() {
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        blockViewer.draw(block, gui);
        Mockito.verify(gui, Mockito.times(1)).drawBlock(block.getPosition());
    }
}
