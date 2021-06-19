package com.g56.controller.game;

import com.g56.Game;
import com.g56.controller.Controller;
import com.g56.model.game.element.powerup.PowerupBuilder;
import com.g56.gui.GUI;
import com.g56.model.game.Position;
import com.g56.model.game.field.Field;
import com.g56.model.menu.LooserMenu;
import com.g56.model.menu.Menu;
import com.g56.model.menu.WinnerMenu;
import com.g56.states.MenuState;
import com.g56.states.ResultState;
import com.g56.utils.RandomGenerator;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class FieldController extends Controller<Field> {
    private PlayerController playerController;
    private BombController bombController;
    private WallController wallController;
    private PowerupController powerupController;

    private List<EnemyController> enemyControllers = new ArrayList<>();


    public FieldController(Field field) {
        super(field);
    }

    public void setPlayerController(PlayerController playerController) {
        this.playerController = playerController;
    }

    public void setBombController(BombController bombController) {
        this.bombController = bombController;
    }

    public void setWallController(WallController wallController) {
        this.wallController = wallController;
        wallController.applyObservers(powerupController);
    }

    public void setPowerupController(PowerupController powerupController) {
        this.powerupController = powerupController;
    }

    public void setEnemyControllers(List<EnemyController> enemyControllers) {
        this.enemyControllers = enemyControllers;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        if(action == GUI.ACTION.QUIT){ //QUIT CONDITION
            game.setState(new MenuState(new Menu()));
        }
        else if(getModel().getPlayer().getLife() <= 0){ //LOOSE CONDITION
            game.setState(new ResultState(new LooserMenu()));
        }
        else if(!getModel().haveEnemies()) { //WIN CONDITION
            game.setState(new ResultState(new WinnerMenu()));
        }
        else if(action != null){
            playerController.step(game,action,time);

            for(EnemyController enemy: enemyControllers){
                enemy.step(game,action,time);
            }

            bombController.step(game,action,time);

            wallController.step(game,action,time);

            powerupController.step(game,action,time);
        }
    }

}
