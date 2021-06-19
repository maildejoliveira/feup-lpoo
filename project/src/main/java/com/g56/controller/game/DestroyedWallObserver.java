package com.g56.controller.game;

import com.g56.model.game.Position;

public interface DestroyedWallObserver {
    void wallWasDestroyed(Position position);
}
