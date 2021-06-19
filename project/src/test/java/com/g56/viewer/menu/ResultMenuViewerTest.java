package com.g56.viewer.menu;

import com.g56.gui.LanternaGUI;
import com.g56.model.menu.LooserMenu;
import com.g56.model.menu.Menu;
import com.g56.model.menu.ResultMenu;
import com.g56.model.menu.WinnerMenu;
import com.g56.utils.RandomGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class ResultMenuViewerTest {
    private LanternaGUI stubGUI;
    ResultMenuViewer resultMenuViewer;
    private ResultMenu menu;

    @BeforeEach
    public void initiateGUI(){
        stubGUI = Mockito.mock(LanternaGUI.class);
    }

    @Test
    public void drawLooserMenu() throws IOException {
        this.menu = new LooserMenu();
        this.resultMenuViewer = new ResultMenuViewer(menu);
        resultMenuViewer.draw(stubGUI);

        Mockito.verify(stubGUI,Mockito.times(1)).clear();

        //TODO ask how to test random numbers for color and enemy type

        Mockito.verify(stubGUI,Mockito.times(1)).refresh();
    }

    @Test
    public void drawWinnerMenu() throws IOException {
        this.menu = new WinnerMenu();
        this.resultMenuViewer = new ResultMenuViewer(menu);
        resultMenuViewer.draw(stubGUI);

        Mockito.verify(stubGUI,Mockito.times(1)).clear();

        //TODO ask how to test random numbers for color and enemy type

        Mockito.verify(stubGUI,Mockito.times(1)).refresh();
    }
}
