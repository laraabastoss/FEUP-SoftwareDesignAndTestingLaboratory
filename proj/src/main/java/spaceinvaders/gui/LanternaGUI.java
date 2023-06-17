package spaceinvaders.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import spaceinvaders.model.Position;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;



public class LanternaGUI implements GUI {

    private final Screen screen;

    public LanternaGUI(Screen screen){
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height,fontConfig);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }


    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/spaceinvaders.otf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 30);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    @Override
    public String getKey() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return "NONE";

        if (keyStroke.getKeyType() == KeyType.EOF) return "QUIT";
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return "QUIT";
        if (keyStroke.getKeyType() == KeyType.Escape) return "QUIT";

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return "UP";
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return "RIGHT";
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return "DOWN";
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return "LEFT";

        if (keyStroke.getKeyType() == KeyType.Enter) return "SELECT";
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == ' ') return "SPACE";
        return "NONE";

    }



    private void drawCharacter(int x, int y, char c, String color){
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
    }

    @Override
    public void drawSpaceShip(Position position){
        drawCharacter(position.getX(),position.getY(), '$', "#32CD32");
    }

    @Override
    public void drawBlock(Position position){
        drawCharacter(position.getX(), position.getY(), '#', "#3333FF");
    }

    @Override
    public void drawMonster(Position position, char c, String color) {
        drawCharacter(position.getX(), position.getY(), c, color);
    }

    @Override
    public void drawBonusMonster(Position position) {
        drawCharacter(position.getX(), position.getY(), '~', "#FF0000");
    }

    @Override
    public void drawBullet(Position position, String type_bullet){
        if (type_bullet == "up") drawCharacter(position.getX(),position.getY(), '|', "#32CD32");
        else drawCharacter(position.getX(),position.getY(), '|', "#FFFFFF");
    }


}
