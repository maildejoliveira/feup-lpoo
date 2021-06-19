package com.g56.controller.game;

import com.g56.Game;
import com.g56.controller.Controller;
import com.g56.gui.GUI;
import com.g56.model.game.Position;
import com.g56.model.game.element.Element;
import com.g56.model.game.element.bomb.Bomb;
import com.g56.model.game.element.bomb.BombObserver;
import com.g56.model.game.field.Field;

import java.io.IOException;
import java.util.Iterator;

public class BombController extends Controller<Field> implements BombObserver {
    public BombController(Field field) {
        super(field);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        Bomb bomb;
        for(Iterator<Bomb> it = getModel().getBombs().values().iterator(); it.hasNext();){
            bomb = it.next();
            if(bomb.timeToChange(time) <= 0){
                if(bomb.exploded()) it.remove(); //if in explosionState and explosionDuration has passed it can be deleted
                bomb.changeState();
            }
        }
    }

    @Override
    public void doExplosion(Bomb bomb){
        doExplosionDirection(bomb, -1,0); //L
        doExplosionDirection(bomb, 1,0); //R
        doExplosionDirection(bomb, 0,-1); //U
        doExplosionDirection(bomb, 0,1); //D
        doExplosionPosition(bomb);
    }

    //dirs: (1,0)R , (-1,0)L , (0,1)D , (0,-1)U
    private void doExplosionDirection(Bomb bomb, int dirX, int dirY){
        Position pos = new Position(bomb.getPosition().getX()+dirX, bomb.getPosition().getY()+dirY);

        while (Math.abs(pos.getX() - bomb.getPosition().getX()) <= bomb.getRadius() && Math.abs(pos.getY() - bomb.getPosition().getY()) <= bomb.getRadius()){
            bomb.createExplosion(pos);
            if(!explodePosition(pos,bomb.getPower())) break;
            pos = new Position(pos.getX()+dirX, pos.getY()+dirY);
        }
    }

    private boolean explodePosition(Position position, int power){
        boolean explosionContinues = true;

        Element element = getModel().getPowerups().get(position);
        if(element!=null){
            explosionContinues = element.explode(power);
        }
        element = getModel().getWalls().get(position);
        if(element!=null){
            explosionContinues = element.explode(power);
        }
        element = getModel().getEnemies().get(position);
        if(element!=null){
            explosionContinues &= element.explode(power);
        }
        element = getModel().getPlayer();
        if(element != null && element.getPosition().equals(position)){
            explosionContinues &= element.explode(power);
        }
        element = getModel().getBombs().get(position);
        if(element!=null){
            explosionContinues &= element.explode(power);
        }

        return explosionContinues;
    }

    private void doExplosionPosition(Bomb bomb){
        explodePosition(bomb.getPosition(),bomb.getPower());
        bomb.createExplosion(bomb.getPosition());
    }
}