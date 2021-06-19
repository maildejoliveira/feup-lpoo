package com.g56.model.game.element.creature;

import com.g56.model.game.Position;
import com.g56.utils.RandomGenerator;

public class CreatureBuilder {
    private int bombPower;
    private int bombRadius;
    private int bombDuration;
    private int explosionDuration;

    public CreatureBuilder(){
        setDefaultParameters();
    }

    public void setBombPower(int bombPower) {
        this.bombPower = bombPower;
    }

    public void setBombRadius(int bombRadius) {
        this.bombRadius = bombRadius;
    }

    public void setBombDuration(int bombDuration) {
        this.bombDuration = bombDuration;
    }

    public void setExplosionDuration(int explosionDuration) {
        this.explosionDuration = explosionDuration;
    }

    private void setDefaultParameters(){
        this.bombPower = 1;
        this.bombRadius = 1;
        this.bombDuration = 1000;
        this.explosionDuration = 1000;
    }

    public Player createDefaultPlayer(Position position){
        setDefaultParameters();
        return createPlayer(position);
    }

    public Player createPlayer(Position position){
        Player player = new Player(position,10);

        player.setBombPower(bombPower);
        player.setBombDuration(bombDuration);
        player.setBombRadius(bombRadius);
        player.setExplosionDuration(explosionDuration);
        player.setBombsNumber(1);

        return player;
    }

    public Enemy createRandomEnemy(Position position){
        Enemy enemy = new Enemy(position,10);

        enemy.setTimeToPlaceBomb(RandomGenerator.getRandomNumber(1,10));
        enemy.setBombPower(RandomGenerator.getRandomNumber(1,4));
        enemy.setBombRadius(RandomGenerator.getRandomNumber(1,3));
        enemy.setBombDuration(RandomGenerator.getRandomNumber(1000,2000));
        enemy.setExplosionDuration(RandomGenerator.getRandomNumber(1000,2000));
        enemy.setBombsNumber(RandomGenerator.getRandomNumber(1,3));

        return enemy;
    }

    public Enemy createEnemy(Position position){
        Enemy enemy = new Enemy(position,10);

        enemy.setTimeToPlaceBomb(RandomGenerator.getRandomNumber(1,10));
        enemy.setBombPower(bombPower);
        enemy.setBombDuration(bombDuration);
        enemy.setBombRadius(bombRadius);
        enemy.setExplosionDuration(explosionDuration);
        enemy.setBombsNumber(RandomGenerator.getRandomNumber(1,3));

        return enemy;
    }

}
