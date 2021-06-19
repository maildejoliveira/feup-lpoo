package com.g56.model.game.field;

import com.g56.model.game.element.bomb.Bomb;
import com.g56.model.game.element.creature.Enemy;
import com.g56.model.game.element.creature.Player;
import com.g56.model.game.element.powerup.Powerup;
import com.g56.model.game.element.wall.Wall;
import com.g56.model.game.Position;
import com.g56.utils.RandomGenerator;


import java.util.*;

public class Field {
    private final int width;
    private final int height;

    private Player player;

    private Map<Position, Wall> walls = new HashMap<>();
    private final Map<Position, Bomb> bombs = new HashMap<>();
    private final Map<Position, Enemy> enemies = new HashMap<>();
    private final Map<Position, Powerup> powerups = new HashMap<>();

    private final int numberOfEnemies;

    public Field(int width, int height, int numberOfEnemies) {
        this.width = width;
        this.height = height;
        this.numberOfEnemies = numberOfEnemies;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Map<Position, Wall> getWalls() {
        return walls;
    }

    public void setWalls(Map<Position, Wall> walls) {
        this.walls = walls;
    }

    public void addBomb(Bomb bomb){
        this.bombs.put(bomb.getPosition(),bomb);
    }

    public Map<Position, Bomb> getBombs() {
        return bombs;
    }

    public void addPowerup(Powerup powerup){
        this.powerups.put(powerup.getPosition(),powerup);
    }

    public Map<Position, Powerup> getPowerups() {
        return powerups;
    }

    public int getNumberOfEnemies() {
        return numberOfEnemies;
    }

    public Map<Position, Enemy> getEnemies() {
        return enemies;
    }

    public void addEnemy(Enemy enemy){
        this.enemies.put(enemy.getPosition(),enemy);
    }

    public Position generateValidPosition(){
        Position position;
        do{
            position = new Position(RandomGenerator.getRandomNumber(0,width), RandomGenerator.getRandomNumber(2,height + 2));
        }while(!positionIsEmpty(position));
        return position;
    }

    public boolean haveBomb(Position position){
        return bombs.get(position) != null;
    }

    public boolean haveExplosion(Position position){
        Collection<Bomb> bombIt = bombs.values();
        for(Bomb bomb: bombIt){
            List<Position> positions = bomb.getExplosions();
            for(Position p: positions){
                if(p.equals(position)){
                    return true;
                }
            }
        }
        return false;
    }

    public int getExplosionsPower(Position position){
        int power=0;
        Collection<Bomb> bombIt = bombs.values();
        for(Bomb bomb: bombIt){
            List<Position> positions = bomb.getExplosions();
            for(Position p: positions){
                if(p.equals(position)){
                    power += bomb.getPower();
                }
            }
        }
        return power;
    }

    public boolean positionIsEmpty(Position position){
        if(position.getX() < 0 || position.getX() > width - 1){
            return false;
        }
        if(position.getY() < 0 || position.getY() > height - 1){
            return false;
        }
        return walls.get(position) == null &&
                enemies.get(position) == null &&
                !player.getPosition().equals(position) &&
                (bombs.get(position) == null || bombs.get(position).exploded());
    }

    public boolean haveEnemies(){
        return !enemies.isEmpty();
    }

    public boolean existBreakableWall(){
        for(Wall wall: walls.values()){
            if(wall.canBeDestroyed())
                return true;
        }
        return false;
    }
}
