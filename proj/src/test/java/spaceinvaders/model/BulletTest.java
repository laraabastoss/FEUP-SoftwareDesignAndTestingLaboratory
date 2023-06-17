package spaceinvaders.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spaceinvaders.model.Bullet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BulletTest {
    Bullet bullet;

    @BeforeEach
    public void setUp(){
        bullet = new Bullet(10,10);
    }

    @Test
    public void Type(){
        String type = "up";
        bullet.setType(type);
        assertEquals("up", bullet.getType());
    }
}
