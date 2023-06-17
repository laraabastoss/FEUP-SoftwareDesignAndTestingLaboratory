package spaceinvaders.view;

import spaceinvaders.gui.GUI;
import spaceinvaders.model.BonusMonster;
import spaceinvaders.model.Monster;

public class BonusMonsterViewer implements ElementViewer<Monster>{

    @Override
    public void draw(Monster bonusMonster, GUI gui) {
        if (bonusMonster != null) gui.drawBonusMonster(bonusMonster.getPosition());
    }

}
