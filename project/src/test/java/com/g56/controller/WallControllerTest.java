package com.g56.controller;

import com.g56.controller.game.DestroyedWallObserver;
import com.g56.controller.game.WallController;
import com.g56.model.game.Position;
import com.g56.model.game.element.wall.BreakableWall;
import com.g56.model.game.element.wall.SolidWall;
import com.g56.model.game.element.wall.Wall;
import com.g56.model.game.field.Field;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WallControllerTest {
    private Field field;

    @BeforeEach
    public void initiateField(){
        field = new Field(10,10, 0);
    }

    @Test
    public void testObserverSetting(){
        Wall wallStub1 = Mockito.mock(BreakableWall.class);
        Position wall1Pos = new Position(1,1);
        Mockito.when(wallStub1.getPosition()).thenReturn(wall1Pos);

        Wall wallStub2 = Mockito.mock(SolidWall.class);
        Position wall2Pos = new Position(1,2);
        Mockito.when(wallStub2.getPosition()).thenReturn(wall2Pos);

        HashMap<Position,Wall> map = new HashMap<>();

        map.put(wall1Pos,wallStub1);
        map.put(wall2Pos,wallStub2);
        field.setWalls(map);

        WallController controller = new WallController(field);
        controller.applyObservers(Mockito.mock(DestroyedWallObserver.class));

        Assertions.assertEquals(2,field.getWalls().size());
        controller.toRemove(wallStub1);
        Assertions.assertEquals(1,field.getWalls().size());
        controller.toRemove(wallStub2);
        Assertions.assertEquals(0,field.getWalls().size());

    }
}
