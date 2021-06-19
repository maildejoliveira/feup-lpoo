package com.g56.controller.game;

import com.g56.controller.Controller;
import com.g56.model.game.element.bomb.BombBuilder;
import com.g56.model.game.element.bomb.BombCreatorObserver;
import com.g56.model.game.element.bomb.ParameterizedBombBuilder;
import com.g56.model.game.element.creature.Creature;
import com.g56.model.game.element.powerup.Powerup;
import com.g56.model.game.field.Field;

public abstract class CreatureController extends Controller<Field> implements BombCreatorObserver {
    private BombBuilder builder;

    public CreatureController(Field field) {
        super(field);
    }

    protected void refreshStrategy(Creature creature){
        builder = new ParameterizedBombBuilder(creature.getBombPower(),creature.getBombRadius(),creature.getBombDuration(),creature.getExplosionDuration());
    }

    protected void positionIsExploded(Creature creature){
        int lostLife = getModel().getExplosionsPower(creature.getPosition());
        if(lostLife!=0){
            creature.explode(lostLife);
        }
    }

    protected void positionHasPowerup(Creature creature){
        Powerup powerup =  getModel().getPowerups().get(creature.getPosition());
        if(powerup != null){
            powerup.catchPowerup(creature);
            refreshStrategy(creature);
        }
    }

    protected void placeBomb(Creature creature){
        if(!getModel().haveBomb(creature.getPosition()) && (creature.getBombsNumber() > 0)){
            getModel().addBomb(builder.createBomb(creature.getPosition(), new BombController(getModel()),this));
            creature.setBombsNumber(creature.getBombsNumber() - 1);
        }
    }

}
