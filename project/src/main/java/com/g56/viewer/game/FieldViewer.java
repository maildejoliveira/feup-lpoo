package com.g56.viewer.game;

import com.g56.gui.GUI;
import com.g56.model.game.element.Element;
import com.g56.model.game.element.bomb.Bomb;
import com.g56.model.game.element.creature.Enemy;
import com.g56.model.game.element.creature.Player;
import com.g56.model.game.element.powerup.Powerup;
import com.g56.model.game.element.wall.Wall;
import com.g56.model.game.field.Field;
import com.g56.utils.Colors;
import com.g56.viewer.Viewer;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class FieldViewer extends Viewer<Field> {
    public FieldViewer(Field field) {
        super(field);
    }

    @Override
    protected void drawElements(GUI gui) {
        drawTitle(gui);
        drawPlayerInfo(gui);
        drawPowerup(gui);
        drawElements(gui, getModel().getBombs().values(), new BombViewer());
        drawWalls(gui);
        drawEnemies(gui);
        drawPlayer(gui);
    }

    private <T extends Element> void drawElements(GUI gui, Collection<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.drawElement(element, gui);
    }

    private <T extends Element> void drawElementWithBomb(GUI gui, T element, BombInteractionViewer<T> bombActionViewer){
        bombActionViewer.drawElementWithBomb(element,gui);
    }

    private <T extends Element> void drawElementWithExplosion(GUI gui,T element, ExplosionInteractionViewer<T> explosionInteractionViewer){
        explosionInteractionViewer.drawElementWithExplosion(element,gui);
    }

    private void drawPlayer(GUI gui){
        if (getModel().haveExplosion(getModel().getPlayer().getPosition()))
            drawElementWithExplosion(gui,getModel().getPlayer(), new PlayerViewer());
        else if(getModel().haveBomb(getModel().getPlayer().getPosition()))
            drawElementWithBomb(gui,getModel().getPlayer(), new PlayerViewer());
        else drawElement(gui, getModel().getPlayer(), new PlayerViewer());
    }

    private void drawWalls(GUI gui){
        for(Wall wall : getModel().getWalls().values()){
            if(getModel().haveExplosion(wall.getPosition()))
                drawElementWithExplosion(gui,wall,new WallViewer());
            else drawElement(gui, wall, new WallViewer());
        }
    }

    private void drawEnemies(GUI gui){
        for(Enemy enemy: getModel().getEnemies().values()){
            if (getModel().haveExplosion(enemy.getPosition()))
                drawElementWithExplosion(gui,enemy, new EnemyViewer());
            else if(getModel().haveBomb(enemy.getPosition()))
                drawElementWithBomb(gui,enemy, new EnemyViewer());
            else drawElement(gui, enemy, new EnemyViewer());
        }
    }

    private void drawTitle(GUI gui){
        gui.drawText(getModel().getWidth()/2 - 4,0,"BOMBERMAN");
    }

    private void drawPlayerInfo(GUI gui){
        Player player = getModel().getPlayer();

        gui.setForegroundColor(Colors.ENEMY_PINK);
        gui.drawLife(0,1,player.getLife());
        gui.setForegroundColor(Colors.POWERUP_GREEN);
        gui.drawRadius(4,1,player.getBombRadius());
        gui.setForegroundColor(Colors.EXPLOSION_ORANGE);
        gui.drawPower(8,1,player.getBombPower());
        gui.setForegroundColor(Colors.BOMB_RED);
        gui.drawNumberBombs(12,1,player.getBombsNumber());
        gui.setDefaultForeground();
    }

    private void drawPowerup(GUI gui){
        for(Powerup powerup: getModel().getPowerups().values()){
            drawElement(gui, powerup, new PowerupViewer());
        }
    }
}
