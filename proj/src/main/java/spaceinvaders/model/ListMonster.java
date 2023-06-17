package spaceinvaders.model;

public class ListMonster extends Monster{


    public ListMonster(int x, int y, int points) {
        super(x, y, points);
    }

    @Override
    public boolean switchMonsterDirection(String currdir) {

        if (currdir=="right") {
            Position hip=new Position(position.getX()+1, position.getY());
            return (hip.getX()>79);
        }

        else if (currdir=="left"){
            Position hip=new Position(position.getX()-1, position.getY());
            return (hip.getX()<0);
        }

        return false;
    }
}
