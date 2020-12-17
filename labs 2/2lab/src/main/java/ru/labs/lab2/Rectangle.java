package ru.labs.lab2;

public class Rectangle implements Shape {

    private final double width;
    private final double length;

    public Rectangle(double width, double length) {
        if (width < 0) {
            throw new ShapeException("width < 0");
        }
        if (length < 0) {
            throw new ShapeException("length < 0");
        }
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    @Override
    public double calcArea() {
        return length * width;
    }

    @Override
    public double calcPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return "Rectangle[length=" + length + ",width=" + width + "]";
    }
}