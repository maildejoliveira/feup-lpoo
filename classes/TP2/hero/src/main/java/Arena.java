import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private Hero hero = null;
    private int width;
    private int height;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;

    public Arena(int width,int height){
        this.height=height;
        this.width=width;
        hero=new Hero(10,10);
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters=createMonsters();
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            Position position = new Position(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
            coins.add(new Coin(position.getX(), position.getY()));

        }
        for (int i = 0; i < coins.size()-1; i++) {
            for (int j = i+1; j < coins.size(); j++) {
                if(coins.get(i).getPosition().equals(coins.get(j).getPosition())){
                    coins.remove(j);
                }
            }
        }
        return coins;
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            Position position = new Position(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
            monsters.add(new Monster(position.getX(), position.getY()));

        }
        for (int i = 0; i < monsters.size()-1; i++) {
            for (int j = i+1; j < monsters.size(); j++) {
                if(monsters.get(i).getPosition().equals(monsters.get(j).getPosition())){
                    monsters.remove(j);
                }
            }
        }
        return monsters;
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(this.width, this.height), ' ');
        for (Wall wall : walls)
            wall.draw(graphics);
        for (Coin coin: coins) {
            coin.draw(graphics);
        }
        for (Monster monster: monsters) {
            monster.draw(graphics);
        }
        hero.draw(graphics);
    }

    private boolean canHeroMove(Position position){
        for (Wall wall: walls) {
            if(wall.getPosition().equals(position)){
                return false;
            }
        }
        return true;
    }

    public void moveHero(Position position) {
        if (canHeroMove(position)) {
            retrieveCoins(position);
            hero.setPosition(position);
        }
    }

    private boolean canMonsterMove(Position position){
        for (Wall wall: walls) {
            if(wall.getPosition().equals(position)){
                return false;
            }
        }
        for (Coin coin: coins) {
            if(coin.getPosition().equals(position)){
                return false;
            }
        }
        return true;
    }

    public void moveMonsters() {
        for (Monster m: monsters) {
            Position position = m.move();
            if(canMonsterMove(position)){
                m.setPosition(position);
            }
        }
    }

    public boolean verifyMonsterCollision(Position heroPosition){
        for (Monster m:monsters) {
            if(m.getPosition().equals(heroPosition)){
                return false;
            }
        }
        return true;
    }

    public boolean processKey(KeyStroke key) throws IOException {
        System.out.println(key);
        boolean notQ = true;
        switch (key.getKeyType()) {
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case Character:
                if(key.getCharacter() == 'q'){
                    notQ=false;
                }
                break;
            case  EOF:
                notQ = false;
                break;
        }
        if(coins.isEmpty()){
            notQ=false;
            System.out.println("You won!");
        }
        if(!verifyMonsterCollision(hero.getPosition())){
            notQ=false;
            System.out.println("You loose!");
        }
        moveMonsters();
        return notQ;
    }

    public void retrieveCoins(Position position){
        for (int i = 0; i < coins.size(); i++) {
            if(coins.get(i).getPosition().equals(position)){
                coins.remove(i);
                break;
            }
        }
    }

}
