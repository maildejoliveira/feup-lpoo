package com.g56.model.game.element.powerup;

import com.g56.model.game.element.powerup.strategies.*;
import com.g56.utils.RandomGenerator;

public class RandomPowerupBuilder extends PowerupBuilder{

    @Override
    protected PowerupStrategy getStrategy() {
        switch (RandomGenerator.getRandomNumber(0,11)) {
            case 0:
            case 1:
                return new BombsStrategy(RandomGenerator.getRandomNumber(1,3) * getPosNeg());
            case 2:
            case 3:
                return new PowerStrategy(RandomGenerator.getRandomNumber(1,3) * getPosNeg());
            case 4:
            case 5:
                return new RadiusStrategy(RandomGenerator.getRandomNumber(1,3) * getPosNeg());
            case 6:
            case 7:
                return new DurationStrategy(RandomGenerator.getRandomNumber(200,1500) * getPosNeg());
            case 8:
            case 9:
                return new ExplosionDurationStrategy(RandomGenerator.getRandomNumber(200,1500) * getPosNeg());
            default:
                return new LifeStrategy(1);
        }
    }

    @Override
    protected int getExistenceTime() {
        return RandomGenerator.getRandomNumber(15000,20000);
    }

    private int getPosNeg() {
        switch (RandomGenerator.getRandomNumber(0, 5)) {
            case 0:
            case 1:
            case 2:
                return 1;
            default:
                return -1;
        }
    }
}
