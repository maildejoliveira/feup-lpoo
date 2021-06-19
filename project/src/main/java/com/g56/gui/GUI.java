package com.g56.gui;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawCharacter(int x, int y, char c);

    void drawPlayer(int x, int y);

    void drawEnemy(int x, int y, int c);

    void drawSolidWall(int x, int y);

    void drawBreakableWall(int x, int y, int c);

    void drawBomb(int x, int y);

    void drawPowerup(int x, int y, int c);

    void drawExplosion(int x, int y);

    void drawText(int x, int y, String text);

    void drawLife(int x, int y, int n);

    void drawPower(int x, int y, int n);

    void drawRadius(int x, int y, int n);

    void drawNumberBombs(int x, int y, int n);

    void drawEnterKey(int x, int y);

    void drawArrowUpKey(int x, int y);

    void drawArrowDownKey(int x, int y);

    void setBackgroundColor(String color);

    void setDefaultBackground();

    void setDefaultForeground();

    void setForegroundColor(String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, BOMB, ENTER, NONE, QUIT}
}
