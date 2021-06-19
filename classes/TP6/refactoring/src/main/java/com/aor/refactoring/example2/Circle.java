package com.aor.refactoring.example2;

public class Circle extends Shape {
    private double radius; // ONLY FOR CIRCLES

    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius=radius;
    }

    @Override
    protected TYPE getType(){
        return TYPE.CIRCLE;
    }

    @Override
    public double getArea() throws Exception {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() throws Exception {
        return 2 * Math.PI * radius;
    }

    @Override
    public void draw(GraphicFramework graphics) {
        graphics.drawCircle(x, y, radius);
    }
}
