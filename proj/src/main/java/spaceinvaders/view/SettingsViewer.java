package spaceinvaders.view;

import spaceinvaders.gui.GUI;
import spaceinvaders.model.Position;
import spaceinvaders.model.Settings;

import java.io.IOException;

public class SettingsViewer extends Viewer<Settings> {
    public SettingsViewer(Settings model){super(model);}

    @Override
    protected void drawElements(GUI gui) throws IOException {
        for (int i = 0; i < getModel().getNumberEntries(); i++){
            if (getModel().isSelected(i)) gui.drawText(new Position(29 , 5+i),">","#FFD700");
            gui.drawText(new Position(30 , 5+i),  getModel().getEntry(i) , getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
        gui.drawText(new Position(43 , 5),  getModel().getMuteMusic()? "<Muted>":"<Unmuted>"  , getModel().isSelectedMusic() ? "#FFD700" : "#FFFFFF");
        gui.drawText(new Position(43 , 6),  getModel().getMuteSound()?  "<Muted>":"<Unmuted>" , getModel().isSelectedSound() ? "#FFD700" : "#FFFFFF");

    }
}
