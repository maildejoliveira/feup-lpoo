package com.g56.controller.game;

import com.g56.Game;
import com.g56.controller.Controller;
import com.g56.gui.GUI;
import com.g56.model.game.Position;
import com.g56.model.game.element.bomb.Bomb;
import com.g56.model.game.element.creature.Creature;
import com.g56.model.game.element.powerup.Powerup;
import com.g56.model.game.element.powerup.PowerupBuilder;
import com.g56.model.game.element.powerup.PowerupObserver;
import com.g56.model.game.element.powerup.RandomPowerupBuilder;
import com.g56.model.game.element.powerup.strategies.PowerupStrategy;
import com.g56.model.game.field.Field;
import com.g56.utils.RandomGenerator;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;

public class PowerupController extends Controller<Field> implements PowerupObserver, DestroyedWallObserver {

    public PowerupController(Field field) {
        super(field);
    }

    @Override
    public void toRemove(Powerup powerup) {
        getModel().getPowerups().remove(powerup.getPosition());
    }


    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        Powerup powerup;
        for(Iterator<Powerup> it = getModel().getPowerups().values().iterator(); it.hasNext();){
            powerup = it.next();
            if(powerup.timeToRemove(time) <= 0){
                it.remove();
            }
        }
    }

    private void createPowerup(Position position){
        getModel().addPowerup(new RandomPowerupBuilder().createPowerup(position,this));
    }

    @Override
    public void wallWasDestroyed(Position position) {
        if(RandomGenerator.getRandomNumber(0,2) == 0) createPowerup(position);
    }
}
