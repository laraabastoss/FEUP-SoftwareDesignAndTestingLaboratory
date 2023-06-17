package spaceinvaders.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.gui.GUI;
import spaceinvaders.model.*;
import spaceinvaders.view.GameViewer;
import spaceinvaders.view.MenuEndGameViewer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameViewerTest {
    ArenaBuilder arenaBuilder;
    SpaceShip spaceship;
    BonusMonster bonusMonster;
    List<Monster> monsters = new ArrayList<>();
    List <Block> walls = new ArrayList<>();

    private Arena arena= new Arena(100,20,2,false);
    private GameViewer gameViewer= new GameViewer(arena);
    private GUI gui;

    @BeforeEach
    void beforeAll() {
        gui = Mockito.mock(GUI.class);
        spaceship = new SpaceShip(35,27);
        spaceship.setBullet(new Bullet(35,27));
        bonusMonster = new BonusMonster(35,4,70);
        arena.setSpaceship(spaceship);
        arena.setBonusMonsters(bonusMonster);
        arena.setWalls(Arrays.asList());
        walls.add(new Block(10,25));
        arena.setWalls(walls);

        int y=3;
        for (int i = 0; i < 4 ; i++) {
            for (int x = 30; x <=70 ; x+=6){
                Monster curr;
                switch (i){
                    case 0:
                        curr = new ListMonster(x,y,30);
                        curr.setColor("#FFFFFF");
                        curr.setChar('&');
                        break;
                    case 1:
                        curr = new ListMonster(x,y,20);
                        curr.setColor("#FFFFFF");
                        curr.setChar('^');
                        break;
                    case 2,3:
                        curr = new ListMonster(x,y,10);
                        curr.setColor(" #00FF00");
                        curr.setChar('@');
                        break;
                    default:
                        curr = new ListMonster(x,y,0);
                }
                curr.setBullet(new Bullet(2,2));
                monsters.add(curr);
            }
            y+=2;
        }
        arena.setMonsters(monsters);
    }


    @Test
    void drawElement() throws IOException {
        gameViewer.drawElements(gui);

        Mockito.verify(gui, Mockito.times(1)).drawSpaceShip(arena.getSpaceship().getPosition());
        Mockito.verify(gui, Mockito.times(1)).drawBonusMonster(arena.getBonusMonsters().getPosition());
        for (Monster m : arena.getMonsters()){
            Mockito.verify(gui, Mockito.times(1)).drawMonster(m.getPosition(), m.getChar(), m.getColor());
            Mockito.verify(gui, Mockito.times(1)).drawBullet(m.getBullet().getPosition(), m.getBullet().getType());
        }
        for (Block b : arena.getWalls()){
            Mockito.verify(gui, Mockito.times(1)).drawBlock(b.getPosition());
        }
        Mockito.verify(gui, Mockito.times(1)).drawBullet(arena.getSpaceship().getBullet().getPosition(), arena.getSpaceship().getBullet().getType());
        Mockito.verify(gui, Mockito.times(2)).refresh();
    }
}
