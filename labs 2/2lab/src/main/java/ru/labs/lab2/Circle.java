package ru.labs.lab2;

public class Circle implements Shape {

    private final double radius;

    public Circle(double radius) {
        if (radius < 0) {
            throw new ShapeException("radius < 0");
        }
        this.radius = radius;
    }

    private double getRadius() {
        return radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double calcPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle[Radius=" + radius + "]";
    }
}
