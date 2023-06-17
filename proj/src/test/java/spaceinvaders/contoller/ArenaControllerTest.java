package spaceinvaders.contoller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.Game;
import spaceinvaders.controller.ArenaController;
import spaceinvaders.controller.MenuLoseController;
import spaceinvaders.controller.MonsterController;
import spaceinvaders.controller.SpaceshipController;
import spaceinvaders.model.*;
import spaceinvaders.state.MenuLoseState;
import spaceinvaders.state.MenuWinState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArenaControllerTest {

    ArenaController arenaController;
    Arena arena;
    Game game;
    SpaceshipController spaceshipController;
    MonsterController monsterController;
    SpaceShip spaceship;
    BonusMonster bonusMonster;

    @BeforeEach
    public void setUp() throws IOException, URISyntaxException, FontFormatException {

        game = Mockito.mock(Game.class);
        game.setplayMusic();
        game.setplaySound();
        arena = new Arena(70,30,1,true);
        spaceship = new SpaceShip(35,27);
        bonusMonster = new BonusMonster(35,4,70);
        arena.setSpaceship(spaceship);
        arena.setWalls(Arrays.asList());
        arena.setMonsters(Arrays.asList());
        arenaController = new ArenaController(arena);
        spaceshipController = new SpaceshipController(arena);
        monsterController = new MonsterController(arena);
    }

    @Test
    public void stepMoveSpaceShip() throws IOException {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new ListMonster(20, 15, 20));
        arena.setMonsters(monsters);

        arenaController.step(game, "RIGHT", 1000);

        assertEquals(36, spaceship.getX());
        assertEquals(27, spaceship.getY());
    }

    @Test
    public void stepLoseGame() throws IOException {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new ListMonster(20, 28, 20));
        arena.setMonsters(monsters);

        arenaController.step(game, "RIGHT", 1000);
        assertTrue(arenaController.LoseGame());
        assertFalse(arenaController.GameEnd());
        assertFalse(arenaController.NextLevel());
    }



    @Test
    public void stepQuit() throws IOException {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new ListMonster(20, 15, 20));
        arena.setMonsters(monsters);

        arenaController.step(game, "QUIT", 1000);

        assertFalse(arenaController.LoseGame());
        assertFalse(arenaController.GameEnd());
        assertFalse(arenaController.NextLevel());

        Mockito.verify(game, Mockito.times(1)).setState(null);
    }

    @Test
    public void stepNextLevel() throws IOException {
        arenaController.step(game, "RIGHT", 1000);

        assertFalse(arenaController.LoseGame());
        assertFalse(arenaController.GameEnd());
        assertTrue(arenaController.NextLevel());
    }

    @Test
    public void stepEndGame() throws IOException {
        arena.setLevel(3);

        arenaController.step(game, "RIGHT", 1000);

        assertFalse(arenaController.LoseGame());
        assertTrue(arenaController.GameEnd());
        assertFalse(arenaController.NextLevel());
    }

}
