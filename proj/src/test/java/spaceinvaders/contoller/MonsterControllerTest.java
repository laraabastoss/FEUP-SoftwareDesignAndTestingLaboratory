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

public class MonsterControllerTest {
    MonsterController monsterController;
    Game game;
    Arena arena;
    ArenaController arenaController;
    SpaceShip spaceship;
    SpaceshipController spaceshipController;
    BonusMonster bonusMonster;

    @BeforeEach
    public void setUp(){
        game = Mockito.mock(Game.class);
        game.setplayMusic();
        game.setplaySound();
        arena = new Arena(80,30,2,true);
        spaceship = new SpaceShip(35,27);
        bonusMonster = new BonusMonster(120,4,70);
        arena.setSpaceship(spaceship);
        arena.setWalls(Arrays.asList());
        arena.setMonsters(Arrays.asList());
        arenaController = new ArenaController(arena);
        spaceshipController = new SpaceshipController(arena);
        monsterController = new MonsterController(arena);
    }

    @Test
    public void stepMonsterShooting() throws IOException {
        arena.setLevel(0);
        List <Monster> monsters = new ArrayList<>();
        monsters.add(new ListMonster(10,10,10));
        arena.setMonsters(monsters);

        monsterController.step(game, "RIGHT", 1000);

        for (Monster m : arena.getMonsters()){
            assertEquals("down", m.getBullet().getType());
        }

    }

    @Test
    public void DeleteMonsterBullet() throws IOException {
        List <Monster> monsters = new ArrayList<>();
        ListMonster newMonster = new ListMonster(10,10,10);
        newMonster.setBullet(new Bullet(35,27));
        monsters.add(newMonster);
        arena.setMonsters(monsters);

        monsterController.step(game, "RIGHT", 1000);

        assertEquals(2, spaceship.getLifes());
        Mockito.verify(game, Mockito.times(1)).getplaySound();
    }

    @Test
    public void switchDirMonsters() throws IOException {

        List<Monster> monsters = new ArrayList<>();
        monsters.add(new ListMonster(79, 10, 10));
        arena.setMonsters(monsters);

        for (Monster m : arena.getMonsters()) {
            assertTrue(m.switchMonsterDirection(arenaController.getCurrdir()));
        }

        assertTrue(bonusMonster.switchMonsterDirection(arenaController.getCurrdirbonus()));

    }

}
