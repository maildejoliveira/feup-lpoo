package com.g56.viewer.game;

import com.g56.gui.GUI;
import com.g56.model.game.element.Element;

public interface ExplosionInteractionViewer<T extends Element> {
    void drawElementWithExplosion(T element, GUI gui);
}
