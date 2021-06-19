package com.g56.viewer.menu;

import com.g56.gui.GUI;
import com.g56.model.menu.Menu;
import com.g56.utils.Colors;
import com.g56.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(3,3,"MENU");

        for(int i=0; i< getModel().getNumberOptions(); i++) {
            if (getModel().getCurrOption() == i) {
                gui.setForegroundColor(Colors.PLAYER_BLUE);
                gui.drawPlayer(2,5+i);
                gui.setDefaultForeground();
                gui.setForegroundColor(Colors.MENU_ORANGE);
            }
            gui.drawText(3, 5 + i, getModel().getOption(i));
            gui.setDefaultForeground();
        }
        gui.setForegroundColor(Colors.MENU_ORANGE);
        gui.drawEnterKey(7,7);
        gui.setDefaultForeground();
        drawArrows(gui);
    }

    private void drawArrows(GUI gui){
        if(getModel().getCurrOption() <= 0){
            gui.setForegroundColor(Colors.MENU_ORANGE);
            gui.drawArrowDownKey(10,10);
            gui.setDefaultForeground();
            gui.drawArrowUpKey(10,9);
        }
        else{
            gui.drawArrowDownKey(10,10);
            gui.setForegroundColor(Colors.MENU_ORANGE);
            gui.drawArrowUpKey(10,9);
            gui.setDefaultForeground();
        }
    }
}
