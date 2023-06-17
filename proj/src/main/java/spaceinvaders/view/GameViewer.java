package spaceinvaders.view;

import spaceinvaders.gui.GUI;
import spaceinvaders.model.*;

import java.io.IOException;
import java.util.List;

public class GameViewer extends Viewer<Arena> {

    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        gui.refresh();
        gui.drawText(new Position(0,0),"Points:"+getModel().getSpaceship().getPoints(),"#FFD700");
        for(int i=0;i<getModel().getSpaceship().getLifes();i++) gui.drawText(new Position(70+i*3,0),"%","#FF0000");
        drawElements(gui, getModel().getWalls(), new BlockViewer());
        drawElements(gui, getModel().getMonsters(), new MonsterViewer());
        drawElement(gui, getModel().getBonusMonsters(), new BonusMonsterViewer());
        drawElement(gui, getModel().getSpaceship(), new SpaceShipViewer());
        if (getModel().getSpaceship().getBullet() != null) {
            drawElement(gui, getModel().getSpaceship().getBullet(), new BulletViewer());
        }
        for (Monster m : getModel().getMonsters()){
            if (m.getBullet() != null){
                drawElement(gui, m.getBullet(), new BulletViewer());
            }
        }

        gui.refresh();
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }

}
