package spaceinvaders.view;

import spaceinvaders.gui.GUI;
import spaceinvaders.model.MenuEndGame;
import spaceinvaders.model.MenuWin;
import spaceinvaders.model.Position;

public class MenuEndGameViewer extends Viewer<MenuEndGame> {
    public MenuEndGameViewer(MenuEndGame menu_end) {
        super(menu_end);
    }

    @Override
    public void drawElements(GUI gui){
        gui.drawText(new Position(26, 5), "This is the end of the game!", "#32CD32");
        for (int i = 0; i < getModel().getNumberEntries(); i++){
            if (getModel().isSelected(i)) gui.drawText(new Position(28 , 9+i),">","#FFD700");
            gui.drawText(new Position(29 , 9 + i), getModel().getEntry(i), getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }
}
