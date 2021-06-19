package com.g56.model.game.element.wall;

import com.g56.model.game.Position;

public class SolidWall extends Wall{
    public SolidWall(Position position) {
        super(position);
    }

    @Override
    public boolean canBeDestroyed() {
        return false;
    }

    @Override
    public int getDurability() {
        return 0;
    }

    @Override
    public boolean explode(int power) {
        return false;
    }

}
