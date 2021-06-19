package com.g56.viewer.game;

import com.g56.gui.GUI;
import com.g56.model.game.element.wall.Wall;
import com.g56.utils.Colors;

public class WallViewer implements ElementViewer<Wall>, ExplosionInteractionViewer<Wall>{
    @Override
    public void drawElement(Wall element, GUI gui) {
        if(element.canBeDestroyed()){
            gui.setForegroundColor(Colors.WALL_BROWN);
            gui.drawBreakableWall(element.getPosition().getX(),element.getPosition().getY() + 2,element.getDurability());
            gui.setDefaultForeground();
        }
        else{
            gui.setBackgroundColor(Colors.WALL_DARK_GREY);
            gui.setForegroundColor(Colors.WALL_LIGHT_GREY);
            gui.drawSolidWall(element.getPosition().getX(),element.getPosition().getY() + 2);
            gui.setDefaultBackground();
            gui.setDefaultForeground();
        }
    }

    @Override
    public void drawElementWithExplosion(Wall element, GUI gui) {
        if(element.canBeDestroyed()){
            gui.setBackgroundColor(Colors.EXPLOSION_ORANGE);
            gui.drawBreakableWall(element.getPosition().getX(),element.getPosition().getY() + 2,element.getDurability());
            gui.setDefaultBackground();
        }
        else{
            gui.setBackgroundColor(Colors.WALL_DARK_GREY);
            gui.setForegroundColor(Colors.WALL_LIGHT_GREY);
            gui.drawSolidWall(element.getPosition().getX(),element.getPosition().getY() + 2);
            gui.setDefaultBackground();
            gui.setDefaultForeground();
        }
    }
}
