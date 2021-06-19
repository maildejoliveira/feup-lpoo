package com.g56.model.game.element.wall;

import com.g56.model.game.Position;
import com.g56.model.game.element.Element;

public abstract class Wall extends Element {
    private WallObserver observer;

    public Wall(Position position) {
        super(position);
    }

    public abstract boolean canBeDestroyed();

    public abstract int getDurability();

    public void setObserver(WallObserver observer) {
        this.observer = observer;
    }

    protected void notifyObserver(){
        observer.toRemove(this);
    }
}
