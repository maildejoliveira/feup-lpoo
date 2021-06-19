package com.g56.model.game.element.powerup;

import com.g56.model.game.element.creature.Creature;
import com.g56.model.game.element.wall.Wall;

public interface PowerupObserver {
    public void toRemove(Powerup powerup);

}
