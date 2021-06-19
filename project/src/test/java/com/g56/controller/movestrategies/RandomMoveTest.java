package com.g56.controller.movestrategies;

import com.g56.controller.game.movestrategies.RandomMoveStrategy;
import com.g56.model.game.Position;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.Assertions;

public class RandomMoveTest {
    @Property
    public void move(@ForAll @IntRange(max = 50) int x,
                     @ForAll @IntRange(max = 50) int y){
        RandomMoveStrategy moveStrategy = new RandomMoveStrategy();
        Position initialPosition = new Position(x,y);
        Position finalposition= moveStrategy.move(new Position(x,y));
        Assertions.assertTrue(Math.abs(initialPosition.getX()-finalposition.getX())==1 || Math.abs(initialPosition.getY()-finalposition.getY())==1);
    }
}
