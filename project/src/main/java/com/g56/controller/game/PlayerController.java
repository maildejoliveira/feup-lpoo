package com.g56.controller.game;

import com.g56.Game;
import com.g56.gui.GUI;
import com.g56.model.game.Position;
import com.g56.model.game.field.Field;

import java.io.IOException;

public class PlayerController extends CreatureController {
    public PlayerController(Field field) {
        super(field);
        refreshStrategy(getModel().getPlayer());
    }

    private void movePlayer(Position position){
        if(getModel().positionIsEmpty(position)) {
            getModel().getPlayer().setPosition(position);

            positionIsExploded(getModel().getPlayer());
            positionHasPowerup(getModel().getPlayer());
        }
    }

    private void movePlayerLeft(){
        movePlayer(getModel().getPlayer().getPosition().getLeft());
    }

    private void movePlayerRight(){
        movePlayer(getModel().getPlayer().getPosition().getRight());
    }

    private void movePlayerDown(){
        movePlayer(getModel().getPlayer().getPosition().getDown());
    }

    private void movePlayerUp(){
        movePlayer(getModel().getPlayer().getPosition().getUp());
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if(action == GUI.ACTION.LEFT) movePlayerLeft();
        if(action == GUI.ACTION.RIGHT) movePlayerRight();
        if(action == GUI.ACTION.DOWN) movePlayerDown();
        if(action == GUI.ACTION.UP) movePlayerUp();
        if(action == GUI.ACTION.BOMB) placeBomb(getModel().getPlayer());
    }

    @Override
    public void bombExplode() {
        getModel().getPlayer().setBombsNumber(getModel().getPlayer().getBombsNumber() + 1);
    }
}
