package com.aor.refactoring.example5;

public class SouthDirection extends Direction{
    public SouthDirection(Turtle turtle) {
        super(turtle,'S');
    }

    @Override
    public char getDirection() {
        return 'S';
    }
    @Override
    public void moveForward() {
        turtle.setRow(turtle.getRow()+1);
    }
    @Override
    public void rotateRight() {
        turtle.setDirection(new WestDirection(turtle));
    }
    @Override
    public void rotateLeft() {
        turtle.setDirection(new EastDirection(turtle));
    }
}
