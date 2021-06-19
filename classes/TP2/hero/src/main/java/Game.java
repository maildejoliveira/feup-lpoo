import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    private Arena arena;
    private TextGraphics graphics;
    Game(){
        try{
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            this.screen = new TerminalScreen(terminal);
            this.graphics = screen.newTextGraphics();

            this.screen.setCursorPosition(null);   // we don't need a cursor
            this.screen.startScreen();             // screens must be started
            this.screen.doResizeIfNecessary();     // resize screen if necessary

            arena = new Arena(30,15);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void draw() throws IOException {
        screen.clear();
        arena.draw(this.graphics);
        screen.refresh();
    }

    private boolean processKey(KeyStroke key) throws IOException{
        return arena.processKey(key);
    }

    public void run(){
        try{
            boolean notQ;
            do {
                draw();
                KeyStroke key = screen.readInput();
                notQ = processKey(key);
            } while (notQ);
            screen.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
