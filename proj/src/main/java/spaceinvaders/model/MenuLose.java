package spaceinvaders.model;

import java.util.Arrays;
import java.util.List;

public class MenuLose {
    private int curr_level;
    private final List<String> entries;
    private int currentEntry = 0;
    public MenuLose(int curr_level){
        this.curr_level = curr_level;
        this.entries= Arrays.asList("Play Again", "Back to Main Menu");
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

    public boolean isSelectedPlayAgain() {
        return isSelected(0);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

    public int getCurr_level(){return this.curr_level;}
}
