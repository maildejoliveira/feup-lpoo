package com.g56.controller.game;


import com.g56.Game;
import com.g56.controller.Controller;
import com.g56.gui.GUI;
import com.g56.model.game.Position;
import com.g56.model.game.element.wall.Wall;
import com.g56.model.game.element.wall.WallObserver;
import com.g56.model.game.field.Field;

import java.io.IOException;


public class WallController extends Controller<Field> implements WallObserver {
    private DestroyedWallObserver observer;

    public WallController(Field field) {
        super(field);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {}

    public void applyObservers(DestroyedWallObserver observer){
        this.observer = observer;
        for(Wall wall: getModel().getWalls().values()){
            wall.setObserver(this);
        }
    }

    @Override
    public void toRemove(Wall wall) {
        Position position = wall.getPosition();
        getModel().getWalls().remove(position);
        observer.wallWasDestroyed(position);
    }

}
