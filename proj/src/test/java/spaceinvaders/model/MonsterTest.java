package spaceinvaders.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spaceinvaders.model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonsterTest {
    private Monster monster;
    private Monster bonusMonster;

    @BeforeEach
    public void setUp(){
        monster = new ListMonster(1,1,10);
        bonusMonster = new BonusMonster(2,2,20);
    }

    @Test
    public void Points(){
        monster.setPoints(20);
        assertEquals(20, monster.getPoints());
        bonusMonster.setPoints(30);
        assertEquals(30, bonusMonster.getPoints());

    }

    @Test
    public void Position(){
        Position position =new Position(2,2);
        monster.setPosition(position);
        assertEquals(2, monster.getX());
        assertEquals(2, monster.getY());

    }

    @Test
    public void Bullet(){
        Bullet b=new Bullet(2,2);
        monster.setBullet(b);
        assertEquals(b, monster.getBullet());

    }

    @Test
    public void Char(){
        monster.setChar('-');
        assertEquals('-', monster.getChar());
    }

    @Test
    public void Color(){
        monster.setColor("#FFFFFF");
        assertEquals("#FFFFFF", monster.getColor());
    }

    @Test
    public void switchMonsterDirection(){
        Position position =new Position(79,50);
        monster.setPosition(position);
        bonusMonster.setPosition(position);
        assertEquals(true, monster.switchMonsterDirection("right"));
        assertEquals(false, bonusMonster.switchMonsterDirection("right"));
        assertEquals(false, monster.switchMonsterDirection("left"));
        assertEquals(false, bonusMonster.switchMonsterDirection("left"));
        assertEquals(false, monster.switchMonsterDirection("hdh"));
        assertEquals(false, bonusMonster.switchMonsterDirection("hdh"));
    }





}
