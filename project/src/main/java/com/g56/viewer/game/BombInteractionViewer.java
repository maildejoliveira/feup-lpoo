package com.g56.viewer.game;

import com.g56.gui.GUI;
import com.g56.model.game.element.Element;

public interface BombInteractionViewer<T extends Element> {
    void drawElementWithBomb(T element, GUI gui);
}
