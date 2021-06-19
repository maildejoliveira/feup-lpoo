package com.g56.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI {
    private final TerminalScreen screen;
    private final TextGraphics graphics;

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        screen = createScreen(terminal);
        graphics = screen.newTextGraphics();
    }

    private TerminalScreen createScreen(Terminal terminal) throws IOException {
        final TerminalScreen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/bomberMan.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == ' ') return ACTION.BOMB;
        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.ENTER;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;

        return ACTION.NONE;
    }

    @Override
    public void drawCharacter(int x, int y, char c) {
        //screen.setCharacter(x, y, TextCharacter.fromCharacter(c)[0]);
        graphics.putString(x,y , String.valueOf(c));
    }

    @Override
    public void drawPlayer(int x, int y){
        drawCharacter(x,y,'z');
    }

    @Override
    public void drawEnemy(int x, int y, int c) {
        drawCharacter(x,y,(char)('z'-c));
    }

    @Override
    public void drawSolidWall(int x, int y){
        drawCharacter(x,y,'#');
    }



    @Override
    public void drawBreakableWall(int x, int y, int c){
        //drawCharacter(x,y,(char)(c+'0'));
        drawCharacter(x,y,(char)(c+'`'));
    }

    @Override
    public void drawBomb(int x, int y){
        //drawCharacter(x,y,'B');
        drawCharacter(x,y,'@');
    }

    @Override
    public void drawPowerup(int x, int y, int c) {
        drawCharacter(x,y,(char)('k' + c));
    }

    @Override
    public void drawExplosion(int x, int y) {
        //drawCharacter(x,y,'E');
        drawCharacter(x,y,'*');
    }

    @Override
    public void drawText(int x, int y, String text) {
        graphics.putString(x,y, text);
    }

    @Override
    public void drawLife(int x, int y, int n) {
        drawCharacter(x,y,'<');
        drawText(x+1,y,String.valueOf(n));
    }

    @Override
    public void drawPower(int x, int y, int n) {
        drawCharacter(x,y,'*');
        drawText(x+1,y,String.valueOf(n));
    }

    @Override
    public void drawRadius(int x, int y, int n) {
        drawCharacter(x,y,'?');
        drawText(x+1,y,String.valueOf(n));
    }

    @Override
    public void drawNumberBombs(int x, int y, int n) {
        drawCharacter(x,y,'@');
        drawText(x+1,y,String.valueOf(n));
    }

    @Override
    public void drawEnterKey(int x, int y) {
        drawCharacter(x,y,',');
    }

    @Override
    public void drawArrowUpKey(int x, int y) {
        drawCharacter(x,y,'+');
    }

    @Override
    public void drawArrowDownKey(int x, int y) {
        drawCharacter(x,y,'-');
    }

    @Override
    public void setBackgroundColor(String color) {
        graphics.setBackgroundColor(TextColor.Factory.fromString(color));
    }

    @Override
    public void setDefaultBackground() {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
    }

    @Override
    public void setDefaultForeground() {
        graphics.setForegroundColor(TextColor.Factory.fromString("#aaaaaa"));
    }

    @Override
    public void setForegroundColor(String color) {
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}
