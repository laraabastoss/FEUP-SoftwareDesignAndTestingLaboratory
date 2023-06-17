package spaceinvaders.model;

import spaceinvaders.soundeffects.LoseSound;
import spaceinvaders.soundeffects.MonsterKilledSound;
import spaceinvaders.soundeffects.SoundEffect;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;
    private int level;
    private boolean playSound;

    
    private SpaceShip spaceship;
    
    private List<Monster> monsters;
    private Monster bonusMonster;
    private List<Block> walls;

    private final SoundEffect killedMonsters;

    
    public Arena(int w, int h, int l, boolean a){
        width = w;
        height = h;
        level = l;
        killedMonsters=new MonsterKilledSound();
        playSound=a;
    }

    public int getHeight() {return height;}

    public int getLevel() {return level;}
    public SpaceShip getSpaceship() {return spaceship;}
    public void setSpaceship(SpaceShip ss){spaceship = ss;}
    public List<Monster> getMonsters(){return monsters;}
    public Monster getBonusMonsters(){return bonusMonster;}
    public void setMonsters(List<Monster> m){monsters = m;}
    public void setBonusMonsters(Monster m){bonusMonster = m;}

    public List<Block> getWalls(){return walls;}
    public void setWalls(List<Block> w){walls = w;}
    public void setLevel(int level){this.level = level;}

    public boolean isWall(Position position){
        for (Block block : walls){
            if (block.getPosition().equals(position)) {
                walls.remove(block);
                return true;
            }
        }
        return false;
    }

    public boolean monsterHit(){
        for (Monster monster : monsters){
            if (monster.getPosition().equals(getSpaceship().getBullet().getPosition()) || monster.getPosition().equals(new Position(getSpaceship().getBullet().getPosition().getX(),getSpaceship().getBullet().getPosition().getY() - 1))) {
                if (playSound) killedMonsters.play();
                spaceship.increasepoints(monster.getPoints());
                monsters.remove(monster);
                return true;
            }
        }

        if (bonusMonster != null) {
            if (bonusMonster.getPosition().equals(getSpaceship().getBullet().getPosition())) {
                if (playSound) killedMonsters.play();
                spaceship.increasepoints(bonusMonster.getPoints());
                bonusMonster = null;
                return true;
            }
        }

        return false;

    }


    public boolean isSpaceship(Position position){
        if (spaceship.getPosition().equals(position)) return true;
        return false;
    }

}
