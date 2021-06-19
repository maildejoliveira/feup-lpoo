package com.g56.viewer.game;

import com.g56.gui.GUI;
import com.g56.model.game.element.creature.Enemy;
import com.g56.utils.Colors;


public class EnemyViewer implements ElementViewer<Enemy>, BombInteractionViewer<Enemy>,ExplosionInteractionViewer<Enemy>{

    @Override
    public void drawElement(Enemy enemy, GUI gui) {
        switch (enemy.getEnemyType()){
            case 1:
                gui.setForegroundColor(Colors.ENEMY_PINK);
                break;
            case 2:
                gui.setForegroundColor(Colors.ENEMY_PURPLE);
                break;
            case 3:
                gui.setForegroundColor(Colors.ENEMY_YELLOW);
                break;
        }
        gui.drawEnemy(enemy.getPosition().getX(), enemy.getPosition().getY()+ 2,enemy.getEnemyType());
        gui.setDefaultForeground();
    }

    @Override
    public void drawElementWithBomb(Enemy enemy, GUI gui) {
        gui.setBackgroundColor(Colors.BOMB_RED);
        gui.drawEnemy(enemy.getPosition().getX(), enemy.getPosition().getY()+ 2, enemy.getEnemyType());
        gui.setDefaultBackground();
    }

    @Override
    public void drawElementWithExplosion(Enemy enemy, GUI gui) {
        gui.setBackgroundColor(Colors.EXPLOSION_ORANGE);
        gui.drawEnemy(enemy.getPosition().getX(), enemy.getPosition().getY()+ 2,enemy.getEnemyType());
        gui.setDefaultBackground();
    }
}
