package spaceinvaders.soundeffects;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class GameSound extends SoundEffect{

    public GameSound(){
        super("audios/game.wav");
    }

    protected Clip clip;

    @Override
    public void play(){
        try {

            URL resource = getClass().getClassLoader().getResource(this.soundFile);
            File musicFile=new File(resource.toURI());
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(musicFile.toURI()));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }
    public void stopMusic(){
        clip.stop();
    }


}
