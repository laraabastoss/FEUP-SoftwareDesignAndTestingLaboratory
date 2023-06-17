package spaceinvaders.controller;

import spaceinvaders.Game;
import spaceinvaders.model.Arena;
import spaceinvaders.model.Bullet;
import spaceinvaders.model.Position;
import spaceinvaders.soundeffects.AttackSound;
import spaceinvaders.soundeffects.SoundEffect;

import java.io.IOException;

public class SpaceshipController extends GameController{
    private SoundEffect attackSound;
    public SpaceshipController(Arena arena) {
        super(arena);
        attackSound = new AttackSound();
    }

    @Override
    public void step(Game game, String key, long time) throws IOException {

        if (getModel().getSpaceship().getBullet() != null){

            if (DeleteBullet()) getModel().getSpaceship().setBullet(null);
            else getModel().getSpaceship().getBullet().setPosition(new Position(getModel().getSpaceship().getBullet().getX(), getModel().getSpaceship().getBullet().getY() - 2));
        }


        switch (key){
            case "LEFT":
                if (getModel().getSpaceship().getX()>1)
                getModel().getSpaceship().setPosition(new Position(getModel().getSpaceship().getX()-1,getModel().getSpaceship().getY()));
                break;
            case "RIGHT":
                if (getModel().getSpaceship().getX() < 79)
                getModel().getSpaceship().setPosition(new Position(getModel().getSpaceship().getX()+1,getModel().getSpaceship().getY()));
                break;
            case "SPACE":
                if (CreateBullet() && game.getplaySound()) attackSound.play();
                break;

        }
    }

    private boolean DeleteBullet(){

        if ((getModel().getSpaceship().getBullet().getY() < 0) || (getModel().monsterHit()) || (getModel().isWall(getModel().getSpaceship().getBullet().getPosition()))) {
            return true;
        }
        if(getModel().getSpaceship().getBullet().getY()==18 && getModel().isWall(new Position(getModel().getSpaceship().getBullet().getX(), 17))) return true;
        return false;
    }

    public boolean CreateBullet(){
        if (getModel().getSpaceship().getBullet()== null) {
            Bullet bullet = new Bullet(getModel().getSpaceship().getX(), getModel().getSpaceship().getY() - 1);
            bullet.setType("up");
            getModel().getSpaceship().setBullet(bullet);
            return true;
        }
        return false;
    }
}
