import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element {
    public Monster(int x, int y){
        super(x,y);
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#00FF00"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "M");
        graphics.disableModifiers(SGR.BOLD);
    }

    public Position move() {
        Random random = new Random();
        switch (random.nextInt(4)){
            case 0: //move up
                return new Position(getPosition().getX(),getPosition().getY()-1);
            case 1: //move down
                return new Position(getPosition().getX(),getPosition().getY()+1);
            case 2:
                return new Position(getPosition().getX()-1,getPosition().getY());
            case 3:
                return new Position(getPosition().getX()+1,getPosition().getY());
        }
        return new Position(getPosition().getX(),getPosition().getY());
    }
}
