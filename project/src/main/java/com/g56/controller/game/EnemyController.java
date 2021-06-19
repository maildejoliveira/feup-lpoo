package com.g56.controller.game;

import com.g56.Game;
import com.g56.controller.game.movestrategies.MoveStrategy;
import com.g56.controller.game.movestrategies.RandomMoveStrategy;
import com.g56.gui.GUI;
import com.g56.model.game.Position;
import com.g56.model.game.element.creature.CreatureBuilder;
import com.g56.model.game.element.creature.Enemy;
import com.g56.model.game.element.creature.EnemyObserver;
import com.g56.model.game.field.Field;
import com.g56.utils.RandomGenerator;

import java.io.IOException;

public class EnemyController extends CreatureController implements EnemyObserver {
    private Enemy enemy;
    private MoveStrategy moveStrategy;
    private long lastMovement;

    public EnemyController(Field field) {
        super(field);
        this.lastMovement = 0;
    }

    public void associateEnemy(Enemy enemy, MoveStrategy moveStrategy){
        this.enemy = enemy;
        this.moveStrategy = moveStrategy;
        this.enemy.setObserver(this);
        getModel().addEnemy(enemy);
        refreshStrategy(enemy);
    }

    private Enemy generateEnemy(){
        return new CreatureBuilder().createRandomEnemy(getModel().generateValidPosition());
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        verifyLife();
        if(enemy != null && time - lastMovement > 500){
            moveEnemy();
            lastMovement = time;
        }
    }

    private void moveEnemy(){
        Position position = moveStrategy.move(enemy.getPosition());
        if(getModel().positionIsEmpty(position)) {
            getModel().getEnemies().remove(enemy.getPosition());
            enemy.setPosition(position);
            getModel().addEnemy(enemy);
            positionIsExploded(enemy);
            positionHasPowerup(enemy);
        }
        enemy.decrementTimeToPlaceBomb();
    }

    private void verifyLife(){
        if(enemy != null && enemy.getLife() <= 0){
            getModel().getEnemies().remove(enemy.getPosition());
            this.enemy = null;
            if(getModel().existBreakableWall()) associateEnemy(generateEnemy(),new RandomMoveStrategy());
        }
    }

    @Override
    public void readyToPlaceBomb() {
        placeBomb(enemy);
        enemy.setTimeToPlaceBomb(RandomGenerator.getRandomNumber(3,15));
    }

    @Override
    public void bombExplode() {
        enemy.setBombsNumber( enemy.getBombsNumber() + 1);
    }
}
