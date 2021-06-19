package com.g56;

import com.g56.model.menu.Menu;
import com.g56.states.MenuState;
import com.g56.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private State state;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.state = new MenuState(new Menu());
    }

    public void setState(State state) throws IOException {
        this.state.closeGUI();
        this.state = state;
    }

    private void startGame() throws IOException, FontFormatException, URISyntaxException {
        int FPS = 60;
        int frameTime = 1000 / FPS;

        while (this.state!=null){
            long startTime = System.currentTimeMillis();

            state.step(this,startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            if (sleepTime > 0) try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException ignored) {
            }
        }

    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().startGame();
    }
}
