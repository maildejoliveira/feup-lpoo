package com.g56.viewer.game;

import com.g56.gui.GUI;
import com.g56.model.game.element.powerup.Powerup;
import com.g56.model.game.element.wall.Wall;
import com.g56.utils.Colors;

public class PowerupViewer implements ElementViewer<Powerup>{
    @Override
    public void drawElement(Powerup powerup, GUI gui) {
        if(powerup.isIncrement()) gui.setForegroundColor(Colors.POWERUP_GREEN);
        else gui.setForegroundColor(Colors.POWERUP_RED);
        gui.drawPowerup(powerup.getPosition().getX(),powerup.getPosition().getY() + 2,powerup.getPowerupType());
        gui.setDefaultForeground();
    }
}
