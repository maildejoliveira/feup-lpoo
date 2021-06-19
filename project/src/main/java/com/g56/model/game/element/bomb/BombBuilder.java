package com.g56.model.game.element.bomb;

import com.g56.model.game.Position;
import com.g56.model.game.element.bomb.Bomb;
import com.g56.model.game.element.bomb.BombCreatorObserver;
import com.g56.model.game.element.bomb.BombObserver;

public abstract class BombBuilder {

    public Bomb createBomb(Position pos, BombObserver bombObserver, BombCreatorObserver creatorObserver){
        Bomb bomb = new Bomb(pos, getBombPower(), getBombRadius(), getBombDuration(), getBombExplosionDuration());
        bomb.setObserver(bombObserver);
        bomb.setCreatorObserver(creatorObserver);
        return bomb;
    }

    protected abstract int getBombPower();

    protected abstract int getBombRadius();

    protected abstract int getBombDuration();

    protected abstract int getBombExplosionDuration();

}
