package spaceinvaders.gui;

import spaceinvaders.model.Position;


import java.io.IOException;

public interface GUI {

    void drawSpaceShip(Position position);

    void drawBlock(Position position);

    void drawMonster(Position position, char c, String color);

    void drawBullet(Position position, String type);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;


    void drawText(Position position, String text, String color);

    public String getKey() throws IOException;

    void drawBonusMonster(Position position);
}
