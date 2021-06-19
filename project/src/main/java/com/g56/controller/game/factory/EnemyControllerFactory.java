package com.g56.controller.game.factory;

import com.g56.controller.game.EnemyController;
import com.g56.controller.game.movestrategies.RandomMoveStrategy;
import com.g56.model.game.element.creature.CreatureBuilder;
import com.g56.model.game.field.Field;
import com.g56.utils.RandomGenerator;

public class EnemyControllerFactory extends ControllerFactory{
    @Override
    protected EnemyController createController(Field field) {
        EnemyController controller = new EnemyController(field);
        CreatureBuilder creatureBuilder = new CreatureBuilder();

        controller.associateEnemy(creatureBuilder.createRandomEnemy(field.generateValidPosition())
                ,new RandomMoveStrategy());

        return controller;
    }

}
