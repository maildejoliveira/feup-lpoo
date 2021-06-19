package com.g56.model.game.element;

import com.g56.model.game.Explodable;
import com.g56.model.game.Position;

public abstract class Element implements Explodable {
    private Position position;

    public Element(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
