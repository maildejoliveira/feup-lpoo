package com.g56.model.game.element.bomb;

public class ParameterizedBombBuilder extends BombBuilder{
    private final int bombPower;
    private final int bombRadius;
    private final int bombDuration;
    private final int explosionDuration;

    public ParameterizedBombBuilder(int bombPower, int bombRadius, int bombDuration, int explosionDuration) {
        super();
        this.bombPower = bombPower;
        this.bombRadius = bombRadius;
        this.bombDuration = bombDuration;
        this.explosionDuration = explosionDuration;
    }

    @Override
    protected int getBombPower() {
        return bombPower;
    }

    @Override
    protected int getBombRadius() {
        return bombRadius;
    }

    @Override
    protected int getBombDuration() {
        return bombDuration;
    }

    @Override
    protected int getBombExplosionDuration() {
        return explosionDuration;
    }
}
