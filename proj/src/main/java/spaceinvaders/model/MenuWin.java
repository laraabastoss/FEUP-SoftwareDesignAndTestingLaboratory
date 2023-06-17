package spaceinvaders.model;

import java.util.Arrays;
import java.util.List;

public class MenuWin {
    private int next_level;

    private final List<String> entries;
    private int currentEntry = 0;
    public MenuWin(int next_level){
        this.next_level = next_level;
        this.entries= Arrays.asList("Next Level", "Back to Main Menu");
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

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedBacktoMenu() {
        return isSelected(1);
    }

    public boolean isSelectedNextLevel() {
        return isSelected(0);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

    public int getNext_level(){return this.next_level;}
}
