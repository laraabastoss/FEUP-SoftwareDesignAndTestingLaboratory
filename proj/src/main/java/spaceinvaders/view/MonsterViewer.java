package spaceinvaders.view;

import spaceinvaders.gui.GUI;
import spaceinvaders.model.Monster;

public class MonsterViewer implements ElementViewer<Monster> {

    @Override
    public void draw(Monster monster, GUI gui){
     gui.drawMonster(monster.getPosition(), monster.getChar(),monster.getColor());
    }
}
