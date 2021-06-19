package com.aor.refactoring.example5;

public class NorthDirection extends Direction{
    public NorthDirection(Turtle turtle) {
        super(turtle, 'N');
    }

    @Override
    public char getDirection() {
        return 'N';
    }
    @Override
    public void moveForward() {
        turtle.setRow(turtle.getRow()-1);
    }
    @Override
    public void rotateRight() {
        turtle.setDirection(new EastDirection(this.turtle));
    }
    @Override
    public void rotateLeft() {
        turtle.setDirection(new WestDirection(this.turtle));
    }
}
