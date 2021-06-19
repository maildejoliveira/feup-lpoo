package com.g56.viewer.game;

import com.g56.gui.GUI;
import com.g56.model.game.element.creature.Player;
import com.g56.utils.Colors;

import java.awt.*;

public class PlayerViewer implements ElementViewer<Player>, BombInteractionViewer<Player>,ExplosionInteractionViewer<Player> {
    @Override
    public void drawElement(Player player, GUI gui) {
        gui.setForegroundColor(Colors.PLAYER_BLUE);
        gui.drawPlayer(player.getPosition().getX(), player.getPosition().getY()+ 2);
        gui.setDefaultForeground();
    }

    @Override
    public void drawElementWithBomb(Player player, GUI gui) {
        gui.setBackgroundColor(Colors.BOMB_RED);
        gui.drawPlayer(player.getPosition().getX(), player.getPosition().getY()+ 2);
        gui.setDefaultBackground();
    }

    @Override
    public void drawElementWithExplosion(Player player, GUI gui) {
        gui.setBackgroundColor(Colors.EXPLOSION_ORANGE);
        gui.drawPlayer(player.getPosition().getX(), player.getPosition().getY() + 2);
        gui.setDefaultBackground();
    }
}
