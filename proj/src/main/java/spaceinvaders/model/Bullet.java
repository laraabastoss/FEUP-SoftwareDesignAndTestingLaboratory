package spaceinvaders.model;

public class Bullet extends Element {
    private String type;

    public Bullet(int x, int y){
        super(x,y);
    }

    public void setType(String t){type = t;}
    public String getType(){return type;}
}
