package com.g56.states;

import com.g56.Game;
import com.g56.controller.Controller;
import com.g56.gui.GUI;
import com.g56.viewer.Viewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;
    private final GUI gui;

    public State(T model) throws FontFormatException, IOException, URISyntaxException {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
        this.gui = getGui();
    }

    protected abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController();

    protected abstract GUI getGui() throws FontFormatException, IOException, URISyntaxException;

    public T getModel() {
        return model;
    }

    public void step(Game game, long time) throws IOException, URISyntaxException, FontFormatException {
        GUI.ACTION action = gui.getNextAction();
        controller.step(game, action, time);
        viewer.draw(gui);
    }

    public void closeGUI() throws IOException {
        gui.close();
    }

}
