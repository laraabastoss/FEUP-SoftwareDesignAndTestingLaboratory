package spaceinvaders.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spaceinvaders.model.Bullet;
import spaceinvaders.model.Position;
import spaceinvaders.model.SpaceShip;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpaceshipTest {
    private SpaceShip spaceship;


    @BeforeEach
    public void setUp(){
        spaceship = new SpaceShip(10,10);
    }
    @Test
    public void Lifes(){
        for (int i=0; i<3;i++){
            spaceship.decreaselifes();
        }
        assertEquals(0, spaceship.getLifes());
    }

    @Test
    public void Points(){
        for (int i=0; i<3;i++){
            spaceship.increasepoints(10);
        }
        assertEquals(30, spaceship.getPoints());
    }

    @Test
    public void Position(){
        Position position =new Position(2,2);
        spaceship.setPosition(position);
        assertEquals(2, spaceship.getX());
        assertEquals(2, spaceship.getY());

    }

    @Test
    public void Bullet(){
        Bullet b=new Bullet(2,2);
        spaceship.setBullet(b);
        assertEquals(b, spaceship.getBullet());
    }
}
