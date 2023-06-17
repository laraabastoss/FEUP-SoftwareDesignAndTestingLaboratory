package spaceinvaders;

import spaceinvaders.gui.LanternaGUI;
import spaceinvaders.model.Menu;
import spaceinvaders.soundeffects.*;
import spaceinvaders.state.*;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {

    private final LanternaGUI gui;

    private State state;
    private final SoundEffect selectSound;
    private final SoundEffect loseSound;
    private final GameSound gameSound;
    private final SoundEffect nextLevelSound;
    private final SoundEffect gameFinishedlSound;
    protected static boolean playSound=true,playMusic=true;



    public Game() throws FontFormatException, IOException, URISyntaxException{
        this.gui = new LanternaGUI(80, 30);
        this.state = new MenuState(new Menu());
        this.selectSound = new SelectSound();
        this.loseSound = new LoseSound();
        this.gameSound = new GameSound();
        this.nextLevelSound = new NextLevelSound();
        this.gameFinishedlSound = new GameFinishedSound();
    }

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        new Game().start();
    }
    public boolean getplayMusic(){
        return playMusic;
    }

    public boolean getplaySound(){
        return playSound;
    }

    public void setplayMusic(){
        playMusic=!playMusic;
    }

    public void setplaySound(){
        playSound=!playSound;
    }

    public State getState(){return state;}


    private void start() throws IOException {
        int fps = 10;
        int frametime = 1000/fps;

        while (this.state!=null){

            long starttime = System.currentTimeMillis();

            state.step(this, gui, starttime);

            long elapsedtime = System.currentTimeMillis() - starttime;
            long sleeptime = frametime - elapsedtime;

            try {
                if (sleeptime > 0) Thread.sleep(sleeptime);
            }
            catch (InterruptedException e){}
        }
        gui.close();
    }



    public void setState(State s) {
        if (playSound) notifySound(s);
        if (playMusic) notifyMusic(s);
        this.state=s;
    }

    private void notifySound(State s) {
        if (s instanceof GameState){
            selectSound.play();
        }
        if (s instanceof SettingsState){
            selectSound.play();
        }
        if (s instanceof MenuState){
            selectSound.play();
        }
        if (s instanceof MenuWinState){
            nextLevelSound.play();
        }
        if (s instanceof MenuLoseState){
            loseSound.play();
        }
        if (s instanceof MenuEndGameState){
            gameFinishedlSound.play();
        }
    }
    private void notifyMusic(State s) {
        if (s instanceof GameState){
            gameSound.play();
        }
        if (s instanceof MenuWinState){
            gameSound.stopMusic();

        }
        if (s instanceof MenuLoseState){
            gameSound.stopMusic();

        }
        if (s instanceof MenuEndGameState){
            gameSound.stopMusic();

        }
    }
}
