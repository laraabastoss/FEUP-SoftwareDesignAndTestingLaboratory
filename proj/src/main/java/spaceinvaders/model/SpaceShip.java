package spaceinvaders.model;

public class SpaceShip extends Element {
    private int lifes, points;
    private Bullet bullet;

    public SpaceShip(int x, int y){
        super(x,y);
        lifes = 3;
        points = 0;
        bullet = null;
    }

    public void decreaselifes(){lifes--;}
    public void increasepoints(int p){points += p;}

    @Override
    public void setPosition(Position p){
        position = p;
    }
    public int getLifes(){return lifes;}
    public int getPoints(){return points;}

    public void setBullet(Bullet b){this.bullet = b;}

    public Bullet getBullet() {return this.bullet;}

}
