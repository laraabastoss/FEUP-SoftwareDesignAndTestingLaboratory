package spaceinvaders.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.gui.GUI;
import spaceinvaders.model.SpaceShip;
import spaceinvaders.view.SpaceShipViewer;

class SpaceShipViewerTest {
    private SpaceShip spaceship= new SpaceShip(10, 10);
    private SpaceShipViewer spaceshipViewer= new SpaceShipViewer();
    private GUI gui;

    @BeforeEach
    void beforeAll() {
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        spaceshipViewer.draw(spaceship, gui);
        Mockito.verify(gui, Mockito.times(1)).drawSpaceShip(spaceship.getPosition());
    }
}