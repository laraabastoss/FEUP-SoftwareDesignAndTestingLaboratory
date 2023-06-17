package spaceinvaders.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArenaBuilder{

    private final int level;
    private final int width;
    private final int height;
    private boolean playSound;

    public Arena createArena(boolean a) {
        Arena arena = new Arena(getWidth(), getHeight(), getLevel(),a);

        arena.setSpaceship(createSpaceShip());
        arena.setMonsters(createMonsters());
        arena.setBonusMonsters(createBonusMonster());
        arena.setWalls(createWalls());

        return arena;
    }

    public ArenaBuilder(int level, int width, int height, boolean a) throws IOException {
        this.level = level;
        this.width=width;
        this.height=height;
        playSound=a;
    }


    protected int getWidth() {
        return width;
    }


    protected int getHeight() {
        return height;
    }

    protected int getLevel() {return level;}

    protected List<Block> createWalls(){
        List<Block> walls = new ArrayList<>();
        int y = 18;
        for (int x = 4; x < 84; x+= 20) {Block b = new Block(x, y); walls.add(b);}
        for (int x = 5; x < 84; x+= 20) {Block b = new Block(x, y); walls.add(b);}
        for (int x = 6; x < 84; x+= 20) {Block b = new Block(x, y); walls.add(b);}
        for (int x = 10; x < 85; x+= 20) {Block b = new Block(x, y); walls.add(b);}
        for (int x = 11; x < 85; x+= 20) {Block b = new Block(x, y); walls.add(b);}
        for (int x = 12; x < 85; x+= 20) {Block b = new Block(x, y); walls.add(b);}
        y = 16;
        for (int x = 8; x < 90; x += 20) {Block b = new Block(x,y); walls.add(b);}
        y = 17;
        for (int x = 6; x < 84; x+= 20) {Block b = new Block(x, y); walls.add(b);}
        for (int x = 7; x < 85; x+= 20) {Block b = new Block(x, y); walls.add(b);}
        for (int x = 9; x < 85; x+= 20) {Block b = new Block(x, y); walls.add(b);}
        for (int x = 10; x < 85; x+= 20) {Block b = new Block(x, y); walls.add(b);}
        return walls;
    }

    protected List<Monster> createMonsters() {
        List<Monster> monsters = new ArrayList<>();
        int y=3;
        for (int i = 0; i < 4 ; i++) {
            for (int x = 30; x <=70 ; x+=6){
                Monster curr=new ListMonster(x,y,30);
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

                }
                monsters.add(curr);
            }
            y+=2;
        }
        return monsters;
    }

    protected BonusMonster createBonusMonster() {
        int points = (int) (50 + Math.random()*51);
        return new BonusMonster(width/2-3, (int) (height*0.07), points);
    }


    protected SpaceShip createSpaceShip() {
            return new SpaceShip(width/2, (int) (height*0.65));

    }


}