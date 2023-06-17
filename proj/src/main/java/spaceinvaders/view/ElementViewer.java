package spaceinvaders.view;

import spaceinvaders.gui.GUI;
import spaceinvaders.model.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}
