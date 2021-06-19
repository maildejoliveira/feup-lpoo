package com.g56.model.game.element.wall;

import com.g56.model.game.Position;

public class BreakableWall extends Wall{
    private int durability;

    public BreakableWall(Position position, int durability) {
        super(position);
        this.durability = durability;
    }

    @Override
    public boolean canBeDestroyed() {
        return true;
    }

    @Override
    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    @Override
    public boolean explode(int power) {
        durability -= power;
        if(durability <= 0){
            notifyObserver();
        }
        return durability < 0;
    }

}
