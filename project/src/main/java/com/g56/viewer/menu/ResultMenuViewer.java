package com.g56.viewer.menu;

import com.g56.gui.GUI;
import com.g56.model.menu.ResultMenu;
import com.g56.utils.Colors;
import com.g56.utils.RandomGenerator;
import com.g56.viewer.Viewer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultMenuViewer extends Viewer<ResultMenu> {
    private final List<String> colors = Arrays.asList(Colors.PLAYER_BLUE,Colors.ENEMY_PINK,Colors.ENEMY_PURPLE,Colors.ENEMY_YELLOW,Colors.BOMB_RED,Colors.EXPLOSION_ORANGE,Colors.POWERUP_GREEN,Colors.POWERUP_RED,Colors.WALL_BROWN,Colors.WALL_DARK_GREY,Colors.WALL_LIGHT_GREY);
    public ResultMenuViewer(ResultMenu model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        for(int x = 0; x< 12; x++){
            for(int y=0; y<12; y++){
                drawEnemy(gui,x,y, RandomGenerator.getRandomNumber(0,4),getRandomColor());
            }
        }
        gui.drawText(3,4,getModel().getResult());
        gui.drawEnterKey(7,6);
    }

    private void drawEnemy(GUI gui, int x, int y, int c, String color){
        gui.setForegroundColor(color);
        gui.drawEnemy(x,y,c);
        gui.setDefaultForeground();
    }

    private String getRandomColor(){
        return colors.get(RandomGenerator.getRandomNumber(0,colors.size()));
    }
}
