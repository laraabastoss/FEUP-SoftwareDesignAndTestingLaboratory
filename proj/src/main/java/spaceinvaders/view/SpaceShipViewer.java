package spaceinvaders.view;

import spaceinvaders.gui.GUI;
import spaceinvaders.model.SpaceShip;

public class SpaceShipViewer implements ElementViewer<SpaceShip> {

    @Override
    public void draw(SpaceShip spaceShip, GUI gui) {
        gui.drawSpaceShip(spaceShip.getPosition());
    }

}
