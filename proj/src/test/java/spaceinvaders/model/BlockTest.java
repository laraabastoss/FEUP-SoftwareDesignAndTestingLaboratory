package spaceinvaders.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spaceinvaders.model.Block;
import spaceinvaders.model.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlockTest {
    Block block;

    @BeforeEach
    public void setUp(){
        block = new Block(10,10);
    }

    @Test
    public void Position(){
        assertEquals(10, block.getX());
        assertEquals(10, block.getY());
    }
}
