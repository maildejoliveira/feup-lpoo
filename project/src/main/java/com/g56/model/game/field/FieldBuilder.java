package com.g56.model.game.field;

import com.g56.model.game.Position;
import com.g56.model.game.element.creature.Player;
import com.g56.model.game.element.wall.Wall;

import java.util.Map;

public abstract class FieldBuilder {
    public Field createField() {
        Field field = new Field(getWidth(), getHeight(), getNumberOfEnemies());

        field.setPlayer(createPlayer());
        field.setWalls(createWalls());

        return field;
    }
    protected abstract int getNumberOfEnemies();
    protected abstract int getWidth();
    protected abstract int getHeight();
    protected abstract Map<Position,Wall> createWalls();
    protected abstract Player createPlayer();
}
