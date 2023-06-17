package spaceinvaders.controller;

import spaceinvaders.Game;
import spaceinvaders.model.Arena;
import spaceinvaders.model.Bullet;
import spaceinvaders.model.Monster;
import spaceinvaders.model.Position;
import spaceinvaders.soundeffects.HitSpaceshipSound;
import spaceinvaders.soundeffects.SoundEffect;


import java.io.IOException;
import java.util.Random;

import static spaceinvaders.controller.ArenaController.*;

public class MonsterController extends GameController{
    private SoundEffect hitSpaceshipSound;
    private int velocity, nrtiros;


    public MonsterController(Arena arena) {
        super(arena);
        hitSpaceshipSound=new HitSpaceshipSound();
    }

    @Override
    public void step(Game game, String key, long time) throws IOException {

        characteristics();
        moveListMonsters(time);
        moveBonusMonster();
        monstersshooting(game);

    }

    private boolean DeleteBullet(Monster m, Game game){

        if (m.getBullet().getPosition().getY() > getModel().getHeight() || getModel().isWall(m.getBullet().getPosition())) return true;

        else if (m.getBullet().getPosition().equals(getModel().getSpaceship().getPosition())){

            getModel().getSpaceship().decreaselifes();
            if (game.getplaySound()) hitSpaceshipSound.play();
            return true;

        }

        return false;
    }

    private void characteristics(){

        switch (getModel().getLevel()){

            case 1:
                velocity = 8;
                nrtiros = 40;
                break;

            case 2:
                velocity = 6;
                nrtiros = 30;
                break;

            case 3:
                velocity = 4;
                nrtiros = 20;
                break;

            default:
                velocity = 1;
                nrtiros = 1;
                break;
        }
    }

    public void moveListMonsters(long time){

        if (time%velocity==0) {
            down = false;

            for (Monster monster : getModel().getMonsters()) {
                if (monster.switchMonsterDirection(currdir)) {

                    if (currdir == "right") currdir = "left";

                    else if (currdir == "left") {
                        down = true;
                        currdir = "right";
                    }

                    break;
                }
            }

            for (Monster monster : getModel().getMonsters()) {
                if (currdir == "right") {

                    if (down) monster.setPosition(new Position(monster.getX() + 1, monster.getY() + 1));

                    else monster.setPosition(new Position(monster.getX() + 1, monster.getY()));
                }

                else if (currdir == "left") monster.setPosition(new Position(monster.getX() - 1, monster.getY()));
            }

            down = false;
        }
    }

    public void moveBonusMonster(){
        if (getModel().getBonusMonsters() != null) {

            if (getModel().getBonusMonsters().switchMonsterDirection(currdirbonus)) {

                if (currdirbonus == "right") currdirbonus = "left";

                else if (currdirbonus == "left") currdirbonus = "right";
            }

            if (currdirbonus == "right") getModel().getBonusMonsters().setPosition(new Position(getModel().getBonusMonsters().getX() + 1, getModel().getBonusMonsters().getY()));

            else if (currdirbonus == "left") getModel().getBonusMonsters().setPosition(new Position(getModel().getBonusMonsters().getX() - 1, getModel().getBonusMonsters().getY()));
        }
    }

    private void monstersshooting(Game game){
        Random rand = new Random();

        boolean shoot = rand.nextInt(nrtiros)==0;

        if (shoot) {

            Monster randomMonster = getModel().getMonsters().get(rand.nextInt(getModel().getMonsters().size()));

            if (randomMonster.getBullet() == null) {

                Bullet bullet = new Bullet(randomMonster.getPosition().getX(), randomMonster.getPosition().getY() + 1);
                bullet.setType("down");
                randomMonster.setBullet(bullet);

            }
        }

        for (Monster m : getModel().getMonsters()){

            getModel().isWall(m.getPosition());

            if (m.getBullet() != null){

                if (DeleteBullet(m, game)) m.setBullet(null);
                else m.getBullet().setPosition(new Position(m.getBullet().getPosition().getX(), m.getBullet().getPosition().getY() + 1));

            }

        }
    }
}
