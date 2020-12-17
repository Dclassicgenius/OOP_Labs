package ru.labs.lab2;

public class Square implements Shape {

    private final double side;

    public Square(double side) {
        if (side < 0) {
            throw new ShapeException("side < 0");
        }
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public double calcArea() {
        return side * side;
    }

    @Override
    public double calcPerimeter() {
        return side * 4;
    }

    @Override
    public String toString() {
        return "Square [side=" + side + "]";
    }
}
