package com.aor.refactoring.example5;

public class WestDirection extends Direction{
    public WestDirection(Turtle turtle) {
        super(turtle, 'W');
    }

    @Override
    public char getDirection() {
        return 'W';
    }
    @Override
    public void moveForward() {
        turtle.setColumn(turtle.getColumn()-1);
    }
    @Override
    public void rotateRight() {
        this.turtle.setDirection(new NorthDirection(turtle));
    }
    @Override
    public void rotateLeft() {
        this.turtle.setDirection(new SouthDirection(turtle));
    }
}
