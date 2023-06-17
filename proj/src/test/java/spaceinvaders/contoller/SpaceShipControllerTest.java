package spaceinvaders.contoller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.Game;
import spaceinvaders.controller.ArenaController;
import spaceinvaders.controller.MonsterController;
import spaceinvaders.controller.SpaceshipController;
import spaceinvaders.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SpaceShipControllerTest {
    Game game;
    Arena arena;
    SpaceShip spaceship;
    BonusMonster bonusMonster;
    ArenaController arenaController;
    SpaceshipController spaceshipController;
    MonsterController monsterController;

    @BeforeEach
    public void setUp(){
        game = Mockito.mock(Game.class);
        game.setplayMusic();
        game.setplaySound();
        arena = new Arena(80,30,2,true);
        spaceship = new SpaceShip(35,27);
        bonusMonster = new BonusMonster(50,4,70);
        arena.setSpaceship(spaceship);
        arena.setWalls(Arrays.asList());
        arena.setMonsters(Arrays.asList());
        arena.setBonusMonsters(bonusMonster);
        arenaController = new ArenaController(arena);
        spaceshipController = new SpaceshipController(arena);
        monsterController = new MonsterController(arena);
    }

    @Test
    public void stepLeft() throws IOException {
        spaceshipController.step(game, "LEFT", 1000);
        assertEquals(34, spaceship.getX());
        assertEquals(27, spaceship.getY());
    }

    @Test
    public void CreateBullet() throws IOException{
        spaceshipController.step(game, "SPACE", 1000);
        assertEquals(35, spaceship.getBullet().getX());
        assertEquals(26, spaceship.getBullet().getY());
        assertEquals("up", spaceship.getBullet().getType());
        spaceshipController.step(game, "SPACE", 1000);
        assertFalse(spaceshipController.CreateBullet());
    }

    @Test
    public void DeleteBullet() throws IOException{
        spaceship.setBullet(new Bullet(50,6));
        spaceshipController.step(game, "SPACE", 1000);
        assertFalse(spaceshipController.CreateBullet());
        spaceshipController.step(game, "RIGHT", 1000);
        assertEquals(null, spaceship.getBullet());
        assertEquals(null, arena.getBonusMonsters());

        spaceship.setBullet(new Bullet(10, 0));
        spaceshipController.step(game, "SPACE", 1000);
        assertFalse(spaceshipController.CreateBullet());
        spaceshipController.step(game, "RIGHT", 1000);
        assertEquals(null, spaceship.getBullet());

        List<Monster> monsters = new ArrayList<>();
        monsters.add(new ListMonster(10,10,10));
        arena.setMonsters(monsters);

        List<Block> walls = new ArrayList<>();
        walls.add(new Block(2,20));
        arena.setWalls(walls);

        spaceship.setBullet(new Bullet(10,12));
        spaceshipController.step(game, "SPACE", 1000);
        assertFalse(spaceshipController.CreateBullet());
        spaceshipController.step(game, "RIGHT", 1000);
        assertEquals(null, spaceship.getBullet());
        assertEquals(0, arena.getMonsters().size());

        spaceship.setBullet(new Bullet(2, 22));
        spaceshipController.step(game, "SPACE", 1000);
        assertFalse(spaceshipController.CreateBullet());
        spaceshipController.step(game, "LEFT", 1000);
        assertEquals(null, spaceship.getBullet());
        assertEquals(0, arena.getWalls().size());

    }

}
