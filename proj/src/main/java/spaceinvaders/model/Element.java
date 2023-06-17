package spaceinvaders.model;

public class Element {
    protected Position position;

    public Element(int x, int y){
        position = new Position(x,y);
    }

    public Position getPosition() {return position;}
    public void setPosition(Position p) {position = p;}
    public int getX(){
        return position.getX();
    }

    public int getY(){
        return position.getY();
    }



}
