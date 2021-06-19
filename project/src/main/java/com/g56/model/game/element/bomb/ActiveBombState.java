package com.g56.model.game.element.bomb;

public class ActiveBombState extends BombState{
    public ActiveBombState(Bomb bomb) {
        super(bomb);
    }

    @Override
    public void changeState() {
        bomb.setPlacedTime(System.currentTimeMillis());
        bomb.setState(new ExplodedBombState(bomb));
        bomb.getObserver().doExplosion(bomb);
        bomb.getCreatorObserver().bombExplode();
    }

    @Override
    public long timeToChange(long currTime) {
        return bomb.getDuration() - (currTime - bomb.getPlaceTime());
    }

    @Override
    public boolean isExploded() {
        return false;
    }
}
