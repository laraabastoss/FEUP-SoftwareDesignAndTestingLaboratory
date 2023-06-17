package spaceinvaders.view;

import spaceinvaders.gui.GUI;
import spaceinvaders.model.Menu;
import spaceinvaders.model.MenuWin;
import spaceinvaders.model.Position;

public class MenuWinViewer extends Viewer<MenuWin> {
    public MenuWinViewer(MenuWin menuwin) {
        super(menuwin);
    }

    @Override
    public void drawElements(GUI gui){
        gui.drawText(new Position(33, 5), "You won!", "#32CD32");
        for (int i = 0; i < getModel().getNumberEntries(); i++){
            if (getModel().isSelected(i)) gui.drawText(new Position(28 , 9+i),">","#FFD700");
            gui.drawText(new Position(29 , 9 + i), getModel().getEntry(i), getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }

    }
}
