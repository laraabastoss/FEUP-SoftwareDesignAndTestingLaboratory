package spaceinvaders.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spaceinvaders.model.Settings;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SettingsTest {
    Settings settings;

    @BeforeEach
    public void setUp(){
        settings = new Settings(false, false);
    }

    @Test
    public void getEntries(){
        assertEquals(true, settings.isSelectedMusic());
        settings.nextEntry();
        assertEquals(true, settings.isSelectedSound());
        settings.nextEntry();
        assertEquals(true, settings.isSelectedBacktoMenu());
        settings.nextEntry();
        assertEquals(true, settings.isSelectedMusic());
        settings.previousEntry();
        assertEquals(true, settings.isSelected(2));
        assertEquals("Sound", settings.getEntry(1));
        assertEquals(3,settings.getNumberEntries());
    }

    @Test
    public void Sound(){
        settings.setMuteSound();
        assertEquals(false,settings.getMuteSound());
        settings.setMuteMusic();
        assertEquals(false,settings.getMuteMusic());
    }
}
