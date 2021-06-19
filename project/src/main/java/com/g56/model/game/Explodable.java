package com.g56.model.game;

public interface Explodable {
    //destroys and returns true if the explosion continues and false if it can´t continue
    boolean explode(int power);
}
