package com.g56.model;

import com.g56.model.game.Position;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PositionTest {
    private Position position;

    @BeforeEach
    public void initPosition(){
        this.position = new Position(10,10);
    }

    @Property
    void getLeft(@ForAll int x, @ForAll int y) {
        Assertions.assertEquals(x - 1, new Position(x, y).getLeft().getX());
        Assertions.assertEquals(y, new Position(x, y).getLeft().getY());
    }

    @Property
    void getRight(@ForAll int x, @ForAll int y) {
        Assertions.assertEquals(x + 1, new Position(x, y).getRight().getX());
        Assertions.assertEquals(y, new Position(x, y).getRight().getY());
    }

    @Property
    void getUp(@ForAll int x, @ForAll int y) {
        Assertions.assertEquals(x, new Position(x, y).getUp().getX());
        Assertions.assertEquals(y - 1, new Position(x, y).getUp().getY());
    }

    @Property
    void getDown(@ForAll int x, @ForAll int y) {
        Assertions.assertEquals(x, new Position(x, y).getDown().getX());
        Assertions.assertEquals(y + 1, new Position(x, y).getDown().getY());
    }

    @Test
    public void testGetX(){
        Assertions.assertEquals(10,position.getX());
    }

    @Test
    public void testGetY(){
        Assertions.assertEquals(10,position.getY());
    }
}
