package com.g56.viewer.game;

import com.g56.gui.GUI;
import com.g56.model.game.Position;
import com.g56.model.game.element.bomb.Bomb;
import com.g56.utils.Colors;

public class BombViewer implements ElementViewer<Bomb>{
    @Override
    public void drawElement(Bomb bomb, GUI gui) {
        if(!bomb.exploded()){
            gui.setForegroundColor(Colors.BOMB_RED);
            gui.drawBomb(bomb.getPosition().getX(), bomb.getPosition().getY()+ 2);
            gui.setDefaultForeground();
        }
        else{
            for(Position position: bomb.getExplosions()){
                gui.setBackgroundColor(Colors.EXPLOSION_ORANGE);
                gui.drawExplosion(position.getX(),position.getY()+ 2);
                gui.setDefaultBackground();
            }
        }
    }
}
