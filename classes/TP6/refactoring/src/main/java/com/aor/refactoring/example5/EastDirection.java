package com.aor.refactoring.example5;

public class EastDirection extends Direction{
    public EastDirection(Turtle turtle) {
        super(turtle, 'E');
    }

    @Override
    public char getDirection() {
        return 'E';
    }
    @Override
    public void moveForward() {
        turtle.setColumn(turtle.getColumn()+1);
    }
    @Override
    public void rotateRight() {
        turtle.setDirection(new SouthDirection(turtle));
    }
    @Override
    public void rotateLeft() {
        turtle.setDirection(new NorthDirection(turtle));
    }
}
