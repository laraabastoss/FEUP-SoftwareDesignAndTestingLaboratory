package spaceinvaders.view;

import spaceinvaders.gui.GUI;
import spaceinvaders.model.Menu;
import spaceinvaders.model.Position;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }


    @Override
   public void drawElements(GUI gui){
       gui.drawText(new Position(35, 4), "Space Invaders", "#32CD32");
       gui.drawText(new Position(36, 7), "@  ", "#00FF00");
       gui.drawText(new Position(39, 7), "10 Points", "#FFFFFF");
       gui.drawText(new Position(36, 9), "&  20 Points", "#FFFFFF");
       gui.drawText(new Position(36, 11), "^  30 Points", "#FFFFFF");
       gui.drawText(new Position(36, 13), "~", "#FF0000");
       gui.drawText(new Position(39, 13), "? Points", "#FFFFFF");
       for (int i = 0; i < getModel().getNumberEntries(); i++){
           if (getModel().isSelected(i)) gui.drawText(new Position(38 , 15+i),">","#FFD700");
           gui.drawText(new Position(39 , 15+i),  getModel().getEntry(i) , getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }
}
