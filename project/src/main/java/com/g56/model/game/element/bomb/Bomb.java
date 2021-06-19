package com.g56.model.game.element.bomb;

import com.g56.model.game.Explodable;
import com.g56.model.game.Position;
import com.g56.model.game.element.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bomb extends Element implements Explodable {
    private final int radius;
    private final int power;
    private final int duration;
    private long placedTime;
    private final int explosionDuration;
    private BombState state;

    private BombObserver observer;
    private BombCreatorObserver creatorObserver;

    List<Position> explosions;

    //observers
    public Bomb(Position pos, int power, int radius, int duration, int explosionDuration) {
        super(pos);
        this.radius = radius;
        this.power = power;
        this.duration = duration;
        this.explosionDuration = explosionDuration;
        this.state = new ActiveBombState(this);
        this.placedTime = System.currentTimeMillis();
        this.explosions=new ArrayList<>();
    }

    public int getRadius() {
        return radius;
    }

    public int getPower() {
        return power;
    }

    public int getDuration() {
        return duration;
    }

    public long getPlaceTime() {
        return placedTime;
    }

    public int getExplosionDuration() {
        return explosionDuration;
    }

    public boolean exploded() {
        return state.isExploded();
    }

    public void changeState(){
        state.changeState();
    }

    public void setState(BombState state) {
        this.state = state;
    }

    public void setPlacedTime(long placedTime) {
        this.placedTime = placedTime;
    }

    public List<Position> getExplosions() {
        return explosions;
    }

    public long timeToChange(long currTime){
       return state.timeToChange(currTime);
    }

    @Override
    public boolean explode(int power) {
        return state.isExploded();
    }

    public void setObserver(BombObserver observer) {
        this.observer = observer;
    }

    protected BombObserver getObserver() {
        return observer;
    }

    public void setCreatorObserver(BombCreatorObserver creatorObserver) {
        this.creatorObserver = creatorObserver;
    }

    protected BombCreatorObserver getCreatorObserver() {
        return creatorObserver;
    }

    public void createExplosion(Position position){
        explosions.add(position);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bomb bomb = (Bomb) o;
        return radius == bomb.radius && power == bomb.power && duration == bomb.duration && placedTime == bomb.placedTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, power, duration, placedTime);
    }
}
