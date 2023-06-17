package spaceinvaders.model;

public abstract class Monster extends Element {
    private int points;
    private Bullet bullet;
    private char c;
    private String color;

    public Monster(int x, int y, int points){
        super(x,y);
        bullet = null;
        this.points = points;
    }

    @Override
    public void setPosition(Position p){
        position = p;
    }

    public void setPoints(int p){points = p;}
    public int getPoints(){return points;}
    public void setChar(char c){this.c = c;}

    public char getChar(){return c;}
    public void setColor(String color){this.color = color;}
    public String getColor(){return color;}

    public abstract boolean switchMonsterDirection(String currdir);

    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }
}
