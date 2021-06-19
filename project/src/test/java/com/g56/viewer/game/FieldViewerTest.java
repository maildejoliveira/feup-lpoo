package com.g56.viewer.game;

import com.g56.gui.GUI;
import com.g56.gui.LanternaGUI;
import com.g56.model.game.Position;
import com.g56.model.game.element.creature.Player;
import com.g56.model.game.element.wall.BreakableWall;
import com.g56.model.game.element.wall.SolidWall;
import com.g56.model.game.element.wall.Wall;
import com.g56.model.game.field.BasicFieldBuilder;
import com.g56.model.game.field.Field;
import com.g56.viewer.game.FieldViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FieldViewerTest {
    private LanternaGUI stubGUI;
    FieldViewer fieldViewer;
    private Field field;

    @BeforeEach
    public void initiateGUI(){
        stubGUI = Mockito.mock(LanternaGUI.class);

        BasicFieldBuilder bfb = new BasicFieldBuilder(10,10);
        this.field = bfb.createField();
        fieldViewer = new FieldViewer(field);
    }

    @Test
    public void drawField() throws IOException {
        fieldViewer.draw(stubGUI);
        Mockito.verify(stubGUI,Mockito.times(1)).clear();

        //TODO:: VERIFY EVERY ELEMENT DRAWN
        //Mockito.verify(stubGUI,Mockito.times(1)).drawPlayer(field.getPlayer().getPosition().getX(), field.getPlayer().getPosition().getY());

        Mockito.verify(stubGUI,Mockito.times(1)).refresh();
    }

}
