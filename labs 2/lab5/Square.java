package ru.labs.lab5;

public class Square implements Shape {

    private final double side;

    public Square(double side) {
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
