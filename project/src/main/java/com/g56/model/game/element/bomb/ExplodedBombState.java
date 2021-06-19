package com.g56.model.game.element.bomb;

public class ExplodedBombState extends BombState {
    public ExplodedBombState(Bomb bomb) {
        super(bomb);
    }

    @Override
    public void changeState() { }

    @Override
    public long timeToChange(long currTime) {
        return bomb.getExplosionDuration() - (currTime - bomb.getPlaceTime());
    }

    @Override
    public boolean isExploded() {
        return true;
    }

}
