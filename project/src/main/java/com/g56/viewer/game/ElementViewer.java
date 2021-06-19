package com.g56.viewer.game;

import com.g56.gui.GUI;
import com.g56.model.game.element.Element;

public interface ElementViewer<T extends Element> {
    void drawElement(T element, GUI gui);
}
