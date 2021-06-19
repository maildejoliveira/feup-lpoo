package com.g56.viewer.game;

import com.g56.gui.LanternaGUI;
import com.g56.model.game.Position;
import com.g56.model.game.element.creature.Enemy;
import com.g56.utils.Colors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class EnemyViewerTest {
    private Enemy enemy;
    private LanternaGUI stubGUI;
    private EnemyViewer enemyViewer;

    @BeforeEach
    public void initViewer(){
        enemy = new Enemy(new Position(5,5),10);
        stubGUI = Mockito.mock(LanternaGUI.class);
        enemyViewer = new EnemyViewer();
    }

    @Test
    public void drawEnemyType1(){
        while(enemy.getEnemyType() != 1){
            enemy = new Enemy(new Position(5,5),10);
        }

        enemyViewer.drawElement(enemy,stubGUI);

        Mockito.verify(stubGUI,Mockito.times(1)).setForegroundColor(Colors.ENEMY_PINK);
        Mockito.verify(stubGUI,Mockito.times(0)).setForegroundColor(Colors.ENEMY_PURPLE);
        Mockito.verify(stubGUI,Mockito.times(0)).setForegroundColor(Colors.ENEMY_YELLOW);
        Mockito.verify(stubGUI, Mockito.times(1)).drawEnemy(enemy.getPosition().getX(), enemy.getPosition().getY()+2,enemy.getEnemyType());
        Mockito.verify(stubGUI,Mockito.times(1)).setDefaultForeground();
    }

    @Test
    public void drawEnemyType2(){
        while(enemy.getEnemyType() != 2){
            enemy = new Enemy(new Position(5,5),10);
        }

        enemyViewer.drawElement(enemy,stubGUI);

        Mockito.verify(stubGUI,Mockito.times(0)).setForegroundColor(Colors.ENEMY_PINK);
        Mockito.verify(stubGUI,Mockito.times(1)).setForegroundColor(Colors.ENEMY_PURPLE);
        Mockito.verify(stubGUI,Mockito.times(0)).setForegroundColor(Colors.ENEMY_YELLOW);
        Mockito.verify(stubGUI, Mockito.times(1)).drawEnemy(enemy.getPosition().getX(), enemy.getPosition().getY()+2,enemy.getEnemyType());
        Mockito.verify(stubGUI,Mockito.times(1)).setDefaultForeground();
    }

    @Test
    public void drawEnemyType3(){
        while(enemy.getEnemyType() != 3){
            enemy = new Enemy(new Position(5,5),10);
        }

        enemyViewer.drawElement(enemy,stubGUI);

        Mockito.verify(stubGUI,Mockito.times(0)).setForegroundColor(Colors.ENEMY_PINK);
        Mockito.verify(stubGUI,Mockito.times(0)).setForegroundColor(Colors.ENEMY_PURPLE);
        Mockito.verify(stubGUI,Mockito.times(1)).setForegroundColor(Colors.ENEMY_YELLOW);
        Mockito.verify(stubGUI, Mockito.times(1)).drawEnemy(enemy.getPosition().getX(), enemy.getPosition().getY()+2,enemy.getEnemyType());
        Mockito.verify(stubGUI,Mockito.times(1)).setDefaultForeground();
    }

    @Test
    public void drawEnemyWithBomb(){
        enemyViewer.drawElementWithBomb(enemy,stubGUI);

        Mockito.verify(stubGUI, Mockito.times(1)).setBackgroundColor(Colors.BOMB_RED);
        Mockito.verify(stubGUI, Mockito.times(1)).drawEnemy(enemy.getPosition().getX(), enemy.getPosition().getY()+2,enemy.getEnemyType());
        Mockito.verify(stubGUI, Mockito.times(1)).setDefaultBackground();
    }

    @Test
    public void drawEnemyWithExplosion(){
        enemyViewer.drawElementWithExplosion(enemy,stubGUI);

        Mockito.verify(stubGUI, Mockito.times(1)).setBackgroundColor(Colors.EXPLOSION_ORANGE);
        Mockito.verify(stubGUI, Mockito.times(1)).drawEnemy(enemy.getPosition().getX(), enemy.getPosition().getY()+2, enemy.getEnemyType());
        Mockito.verify(stubGUI, Mockito.times(1)).setDefaultBackground();
    }
}
