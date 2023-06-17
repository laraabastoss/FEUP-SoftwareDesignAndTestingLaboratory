package spaceinvaders.view;

import spaceinvaders.gui.GUI;
import spaceinvaders.model.Block;

public class BlockViewer implements ElementViewer<Block> {

    @Override
    public void draw(Block block, GUI gui){
        gui.drawBlock(block.getPosition());
    }

}
