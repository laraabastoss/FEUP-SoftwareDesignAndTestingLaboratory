package spaceinvaders.model;

public class BonusMonster extends Monster{
    public BonusMonster(int x, int y, int points) {
        super(x, y, points);
    }

    @Override
    public boolean switchMonsterDirection(String currdir) {

        if (currdir=="right") {
            Position hip=new Position(position.getX()+1, position.getY());
            return (hip.getX()>120);
        }

        else if (currdir=="left"){
            Position hip=new Position(position.getX()-1, position.getY());
            return (hip.getX()<(-20));
        }

        return false;
    }
}
