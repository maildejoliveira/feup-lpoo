package com.g56.model.game.field;

import com.g56.model.game.element.creature.CreatureBuilder;
import com.g56.model.game.element.creature.Player;
import com.g56.model.game.element.wall.BreakableWall;
import com.g56.model.game.element.wall.SolidWall;
import com.g56.model.game.element.wall.Wall;
import com.g56.model.game.Position;
import com.g56.utils.RandomGenerator;

import java.io.*;
import java.net.URL;
import java.util.*;

public class FileFieldBuilder extends FieldBuilder{
    private final int width;
    private final int height;
    private final int numberOfEnemies;

    private Map<Position,Wall> walls = new HashMap<>();

    private Player player;

    public FileFieldBuilder(String name) throws IOException {
        super();
        URL resource = FileFieldBuilder.class.getResource("/fields/field" + name + ".fld");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
        int c;

        width = Integer.parseInt(br.readLine());
        height = Integer.parseInt(br.readLine());
        numberOfEnemies = Integer.parseInt(br.readLine());

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                c = br.read();
                if ((char) c == 'R') addRandomBreakableWall(new Position(col,row));
                if ((char) c == '#') walls.put(new Position(col, row), new SolidWall(new Position(col, row)));
                if ((char) c == 'P') player = (new CreatureBuilder().createDefaultPlayer(new Position(col, row)));
                if ((char) c > '0' && (char) c <= '9') walls.put(new Position(col, row), new BreakableWall(new Position(col, row), c - '0'));
            }
            br.readLine();

        }
    }

    @Override
    protected int getNumberOfEnemies() {
        return numberOfEnemies;
    }

    @Override
    protected int getWidth(){
        return width;
    }

    protected void addRandomBreakableWall(Position position){
        int number = RandomGenerator.getRandomNumber(0,10);
        if(number != 0){
            walls.put(position, new BreakableWall(position,number));
        }
    }

    @Override
    protected int getHeight() {
        return height;
    }

    @Override
    protected Map<Position,Wall> createWalls() {
        return walls;
    }

    @Override
    protected Player createPlayer() {
        return player;
    }
}
