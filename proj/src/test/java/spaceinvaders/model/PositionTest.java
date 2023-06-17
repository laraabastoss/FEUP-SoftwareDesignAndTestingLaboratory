package spaceinvaders.model;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spaceinvaders.model.Element;
import spaceinvaders.model.Position;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    private Position position;

    @BeforeEach
    public void setUp(){
        position = new Position(1,1);
    }

    @Test
    public void getX(){
        assertEquals(1, position.getX());
    }

    @Test
    public void getY(){
        assertEquals(1, position.getX());
    }

    @Test
    public void moveRight(){
        position.moveRight();
        assertEquals(2, position.getX());
    }
    @Test
    public void moveLeft(){
        position.moveLeft();
        assertEquals(0, position.getX());
    }

    @Test
    public void equals(){
        Position position2=new Position(1,1);
        Position position3=new Position(1,2);

        assertTrue(position.equals(position2));
        assertFalse(position.equals(position3));
    }

    @Test
    public void element(){
        Element element=new Element(5,6);
        element.setPosition(position);

        assertEquals(1, element.getPosition().getX());
        assertEquals(1, element.getPosition().getY());
    }





}
