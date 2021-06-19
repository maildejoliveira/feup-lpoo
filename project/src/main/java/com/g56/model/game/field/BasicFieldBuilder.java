package com.g56.model.game.field;

import com.g56.model.game.element.creature.CreatureBuilder;
import com.g56.model.game.element.creature.Player;
import com.g56.model.game.element.wall.BreakableWall;
import com.g56.model.game.element.wall.SolidWall;
import com.g56.model.game.element.wall.Wall;
import com.g56.model.game.Position;

import java.util.HashMap;
import java.util.Map;

public class BasicFieldBuilder extends FieldBuilder{
    private final int width;
    private final int height;

    public BasicFieldBuilder(int width, int height) {
        super();
        this.width = width;
        this.height = height;
    }

    @Override
    protected int getNumberOfEnemies() {
        return 5;
    }

    @Override
    protected int getWidth() {
        return width;
    }

    @Override
    protected int getHeight() {
        return height;
    }

    @Override
    protected Map<Position, Wall> createWalls() {
        Map<Position,Wall> walls = new HashMap<>();

        for (int x = 0; x < width; x++) {
            walls.put(new Position(x,0), new SolidWall(new Position(x, 0)));
            walls.put(new Position(x, height - 1),new SolidWall(new Position(x, height - 1)));
        }

        for (int y = 1; y < height - 1; y++) {
            walls.put(new Position(0,y),new SolidWall(new Position(0,y)));
            walls.put(new Position(width - 1, y),new SolidWall(new Position(width - 1, y)));
        }

        walls.put(new Position(width-2,height-2),new BreakableWall(new Position(width-2,height-2), 3));

        return walls;
    }

    @Override
    protected Player createPlayer() {
        return (new CreatureBuilder()).createDefaultPlayer(new Position(width/2,height/2));
    }
}
