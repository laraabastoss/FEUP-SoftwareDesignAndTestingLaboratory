package spaceinvaders.view;

import spaceinvaders.gui.GUI;
import spaceinvaders.model.Bullet;
import spaceinvaders.model.SpaceShip;

public class BulletViewer implements ElementViewer<Bullet>{

    @Override
    public void draw(Bullet bullet, GUI gui) {
        gui.drawBullet(bullet.getPosition(), bullet.getType());
    }

}
