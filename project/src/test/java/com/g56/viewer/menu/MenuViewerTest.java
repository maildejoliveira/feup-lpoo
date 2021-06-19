package com.g56.viewer.menu;

import com.g56.gui.GUI;
import com.g56.gui.LanternaGUI;
import com.g56.model.game.field.BasicFieldBuilder;
import com.g56.model.game.field.Field;
import com.g56.model.menu.Menu;
import com.g56.utils.Colors;
import com.g56.viewer.game.FieldViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuViewerTest {
    private LanternaGUI stubGUI;
    MenuViewer menuViewer;
    private Menu menu;

    @BeforeEach
    public void initiateGUI(){
        stubGUI = Mockito.mock(LanternaGUI.class);

        this.menu = new Menu();
        menuViewer = new MenuViewer(menu);
    }

    @Test
    public void drawField() throws IOException {
        menuViewer.draw(stubGUI);
        Mockito.verify(stubGUI,Mockito.times(1)).clear();

        //TODO:: VERIFY EVERY ELEMENT DRAWN
        Mockito.verify(stubGUI,Mockito.times(1)).drawText(3,3,"MENU");

        if(menu.getCurrOption() == 0){
            Mockito.verify(stubGUI,Mockito.times(1)).drawPlayer(2,5);
            Mockito.verify(stubGUI,Mockito.times(0)).drawPlayer(2,6);
            Mockito.verify(stubGUI,Mockito.times(1)).drawText(3,5, menu.getOption(0));
            Mockito.verify(stubGUI,Mockito.times(1)).drawText(3,6, menu.getOption(1));
            Mockito.verify(stubGUI,Mockito.times(1)).drawArrowDownKey(10,10);
            Mockito.verify(stubGUI,Mockito.times(1)).drawArrowUpKey(10,9);
        }
        if(menu.getCurrOption() == 1){
            Mockito.verify(stubGUI,Mockito.times(0)).drawPlayer(2,5);
            Mockito.verify(stubGUI,Mockito.times(1)).drawPlayer(2,6);
            Mockito.verify(stubGUI,Mockito.times(1)).drawText(3,5, menu.getOption(0));
            Mockito.verify(stubGUI,Mockito.times(1)).drawText(3,6, menu.getOption(1));
            Mockito.verify(stubGUI,Mockito.times(1)).drawArrowDownKey(10,10);
            Mockito.verify(stubGUI,Mockito.times(1)).drawArrowUpKey(10,9);
        }

        Mockito.verify(stubGUI, Mockito.times(3)).setForegroundColor(Colors.MENU_ORANGE);
        Mockito.verify(stubGUI,Mockito.times(1)).drawEnterKey(7,7);
        Mockito.verify(stubGUI, Mockito.times(5)).setDefaultForeground();

        Mockito.verify(stubGUI,Mockito.times(1)).refresh();
    }
}
