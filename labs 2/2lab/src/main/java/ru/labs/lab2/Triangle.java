package ru.labs.lab2;

public class Triangle implements Shape {

    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        if (a < 0) {
            throw new ShapeException("side a < 0");
        }
        if (b < 0) {
            throw new ShapeException("side b < 0");
        }
        if (c < 0) {
            throw new ShapeException("side c < 0");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calcArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double calcPerimeter() {
        return a + b + c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    public String toString() {
        return "Triangle of Sides [a =" + a + " b=" + b + " c=" + c +"]";
    }
}
