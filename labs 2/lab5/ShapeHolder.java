package ru.labs.lab5;

import java.util.List;

public class ShapeHolder {
    private List<Shape> shapes;

    public ShapeHolder(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
    }
}