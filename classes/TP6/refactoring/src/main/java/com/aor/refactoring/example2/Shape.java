package com.aor.refactoring.example2;

public abstract class Shape {
    enum TYPE {RECTANGLE, CIRCLE}

    double x;
    double y;

    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    protected abstract TYPE getType();

    public abstract double getArea() throws Exception;

    public abstract double getPerimeter() throws Exception;

    public abstract void draw(GraphicFramework graphics);
}
