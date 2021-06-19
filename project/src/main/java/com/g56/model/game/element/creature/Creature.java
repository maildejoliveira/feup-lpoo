package com.g56.model.game.element.creature;

import com.g56.model.game.Explodable;
import com.g56.model.game.Position;
import com.g56.model.game.element.Element;

public abstract class Creature extends Element {
    private int bombPower;
    private int bombRadius;
    private int bombDuration;
    private int explosionDuration;
    private int bombsNumber;
    protected int life;

    public Creature(Position position, int life) {
        super(position);
        this.life = life;
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

    public int getBombsNumber() {
        return bombsNumber;
    }

    public void setBombsNumber(int bombsNumber) {
        this.bombsNumber = bombsNumber;
    }

    public int getBombPower() {
        return bombPower;
    }

    public int getBombRadius() {
        return bombRadius;
    }

    public int getBombDuration() {
        return bombDuration;
    }

    public int getExplosionDuration() {
        return explosionDuration;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    @Override
    public boolean explode(int power) {
        life-=power;
        return true;
    }
}
