package com.aor.refactoring.example5;

public abstract class Direction {
    private char direction;
    protected Turtle turtle;
    public Direction(Turtle turtle, char d){
        this.direction=d;
        this.turtle=turtle;
    }

    public static Direction createDirection(Turtle turtle, char direction){
        if (direction == 'N') return new NorthDirection(turtle);
        if (direction == 'S') return new SouthDirection(turtle);
        if (direction == 'W') return new WestDirection(turtle);;
        return new EastDirection(turtle);
    }

    public abstract char getDirection();

    public abstract void moveForward();

    public abstract void rotateRight();

    public abstract void rotateLeft();
}
