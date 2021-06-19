package com.g56.model.game.element.powerup;

import com.g56.model.game.Position;
import com.g56.model.game.element.creature.Player;
import com.g56.model.game.element.powerup.strategies.LifeStrategy;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;

public class LifeStrategyTest {
    private LifeStrategy lifeStrategy;

    @BeforeEach
    public void initStrategy(){
        lifeStrategy = new LifeStrategy(3);
    }

    @Test
    public void testAmount(){
        Player player  = new Player(Mockito.mock(Position.class),0);
        lifeStrategy.execute(player);
        Assertions.assertEquals(3,player.getLife());
    }
}
