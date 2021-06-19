package com.g56.model.game.element.creature;

import com.g56.model.game.Position;
import com.g56.utils.RandomGenerator;

public class Enemy extends Creature{
    private int timeToPlaceBomb;
    int enemyType;
    private EnemyObserver observer;

    public Enemy(Position position, int life) {
        super(position, life);
        this.enemyType = RandomGenerator.getRandomNumber(1,4);
    }

    public void setTimeToPlaceBomb(int timeToPlaceBomb) {
        this.timeToPlaceBomb = timeToPlaceBomb;
    }

    public int getEnemyType() {
        return enemyType;
    }

    public void setObserver(EnemyObserver observer) {
        this.observer = observer;
    }

    public void decrementTimeToPlaceBomb(){
        timeToPlaceBomb--;
        if(timeToPlaceBomb<=0) notifyObserver();
    }

    private void notifyObserver(){
        observer.readyToPlaceBomb();
    }
}
