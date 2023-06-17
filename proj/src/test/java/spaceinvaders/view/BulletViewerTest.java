package spaceinvaders.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.gui.GUI;
import spaceinvaders.model.Bullet;
import spaceinvaders.view.BulletViewer;

public class BulletViewerTest {
    private Bullet bullet= new Bullet(10,10);
    private BulletViewer bulletViewer= new BulletViewer();
    private GUI gui;

    @BeforeEach
    void beforeAll() {
        gui = Mockito.mock(GUI.class);
        bullet.setType("up");
    }

    @Test
    void drawElement() {
        bulletViewer.draw(bullet, gui);
        Mockito.verify(gui, Mockito.times(1)).drawBullet(bullet.getPosition(),bullet.getType());
    }
}
