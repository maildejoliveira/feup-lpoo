import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element {
    public Wall(int x, int y){
        super(x,y);
    }

    public Position getPosition() {
        return super.getPosition();
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.putString(new TerminalPosition(super.getPosition().getX(),super.getPosition().getY()), "#");
    }
}
