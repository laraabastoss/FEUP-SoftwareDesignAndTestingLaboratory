package spaceinvaders.model;

public class Position {
    int x,y;
    public Position(int x, int y){
        this.x=x;
        this.y=y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public void moveRight() {
        this.x++;
    }
    public void moveLeft() {
        this.x--;
    }

    public boolean equals(Position p) {
        return this.x == p.getX() && this.y == p.getY();
    }
}

