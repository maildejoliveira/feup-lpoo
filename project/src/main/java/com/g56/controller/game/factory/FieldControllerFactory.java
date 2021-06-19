package com.g56.controller.game.factory;

import com.g56.controller.game.EnemyController;
import com.g56.controller.game.FieldController;
import com.g56.controller.game.PlayerController;
import com.g56.model.game.field.Field;

import java.util.ArrayList;
import java.util.List;

public class FieldControllerFactory extends ControllerFactory{
    BombControllerFactory bombControllerFactory;
    PlayerControllerFactory playerControllerFactory;
    WallControllerFactory wallControllerFactory;
    PowerupControllerFactory powerupControllerFactory;
    EnemyControllerFactory enemyControllerFactory;

    public FieldControllerFactory() {
        this.bombControllerFactory = new BombControllerFactory();
        this.playerControllerFactory = new PlayerControllerFactory();
        this.wallControllerFactory = new WallControllerFactory();
        this.powerupControllerFactory = new PowerupControllerFactory();
        this.enemyControllerFactory = new EnemyControllerFactory();
    }

    @Override
    public FieldController createController(Field field) {
        FieldController controller = new FieldController(field);
        controller.setBombController(bombControllerFactory.createController(field));
        controller.setPlayerController(playerControllerFactory.createController(field));
        controller.setPowerupController(powerupControllerFactory.createController(field));
        controller.setWallController(wallControllerFactory.createController(field));

        List<EnemyController> enemyControllers = new ArrayList<>();
        while(enemyControllers.size() < field.getNumberOfEnemies()){
            enemyControllers.add(enemyControllerFactory.createController(field));
        }
        controller.setEnemyControllers(enemyControllers);

        return controller;
    }

    public void setBombControllerFactory(BombControllerFactory bombControllerFactory) {
        this.bombControllerFactory = bombControllerFactory;
    }

    public void setPlayerControllerFactory(PlayerControllerFactory playerControllerFactory) {
        this.playerControllerFactory = playerControllerFactory;
    }

    public void setWallControllerFactory(WallControllerFactory wallControllerFactory) {
        this.wallControllerFactory = wallControllerFactory;
    }

    public void setPowerupControllerFactory(PowerupControllerFactory powerupControllerFactory) {
        this.powerupControllerFactory = powerupControllerFactory;
    }

    public void setEnemyControllerFactory(EnemyControllerFactory enemyControllerFactory) {
        this.enemyControllerFactory = enemyControllerFactory;
    }

}
