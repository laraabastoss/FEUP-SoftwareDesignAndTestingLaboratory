package spaceinvaders.model;

import java.util.Arrays;
import java.util.List;

public class Settings {
    private final List<String> entries;
    private  static boolean mutemusic=false, mutesound=false;

    private int currentEntry = 0;
    public Settings(boolean a, boolean b){
        this.entries= Arrays.asList("Music", "Sound", "Back to Menu");
        mutemusic=!a;
        mutesound=!b;
    }
    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }
    public boolean getMuteMusic() {
        return mutemusic;
    }
    public boolean getMuteSound() {
        return mutesound;
    }

    public void setMuteMusic(){
        mutemusic=!mutemusic;
    }

    public void setMuteSound(){
        mutesound=!mutesound;
    }


    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedMusic() {
        return isSelected(0);
    }

    public boolean isSelectedSound() {
        return isSelected(1);
    }

    public boolean isSelectedBacktoMenu() {
        return isSelected(2);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}
