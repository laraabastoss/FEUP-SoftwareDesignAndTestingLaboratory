package spaceinvaders.soundeffects;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public abstract class SoundEffect {
    protected final String soundFile;
    protected Clip clip;
    protected boolean playSound=true, playMusic=true;


    public SoundEffect(String soundFile){
        this.soundFile = soundFile;

    }

    public void play(){
        if (playSound) {
            try {
                URL resource = getClass().getClassLoader().getResource(this.soundFile);
                File musicFile = new File(resource.toURI());
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(musicFile.toURI()));
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void stopMusic(){
        clip.stop();
    }
}
